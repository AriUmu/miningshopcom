package mining.service.impl;

import mining.model.Product;
import mining.model.User;
import mining.persistence.ProductRepository;
import mining.persistence.UserRepository;
import mining.service.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserServiceInterface{

    protected static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public User loginUser(User user) throws Exception {
        String email = user.getEmail();
        User userAccess = userRepository.getByEmail(email);
        if (userAccess.getEmail() != null) {
            if (userAccess.getPassword().equals(user.getPassword())) {
                logger.info("User successfully accessed to the page");
                return userAccess;
            }
            throw new Exception("The password is not correct!");
        }
        return null;
    }

    public boolean isAdmin(User user) {
        return user.getIsAdmin();
    }

    public User registrationUser(User user) {
        if (userRepository.getByEmail(user.getEmail()) == null) {
            user.setPassword(encoderPass(user.getPassword()));
            userRepository.save(user);
            logger.info("User " + user.getId()+"was saved succesfully");
            return user;
        } else {
            throw new NullPointerException("The same login is exists yet!");
        }
    }

    public boolean buyProduct(User user, Product product) {
       user.getProduct().add(product.getId());
       User user1 = userRepository.save(user);

       product.getUsers().add(user1.getId());
       productRepository.save(product);

       return true;
    }

    private static String encoderPass(String passwordToHash) {
        byte[] salt = {'a'};
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error with password");
        }
        return generatedPassword;
    }
}
