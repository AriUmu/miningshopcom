package mining.service.impl;

import mining.model.Orders;
import mining.model.Product;
import mining.model.User;
import mining.persistence.OrderRepository;
import mining.persistence.ProductRepository;
import mining.persistence.UserRepository;
import mining.service.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService implements UserServiceInterface{

    protected static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    public User loginUser(String email, String password) throws Exception {
        User userAccess;
        if(!(email.equals(null) || password.equals(null))){
           userAccess = userRepository.getByEmail(email);
        }else {
            return null;
        }
        if (userAccess.getEmail() != null) {
            if (userAccess.getPassword().equals(encoderPass(password))) {
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
            String pass = encoderPass(user.getPassword());
            user.setPassword(pass);
            userRepository.save(user);
            logger.info("User " + user.getId()+"was saved succesfully");
            return user;
        } else {
            throw new NullPointerException("The same login is exists yet!");
        }
    }

    public boolean buyProduct(User user, Product product) {
        Orders orders = new Orders(user.getId(), product.getId());
        orderRepository.save(orders);
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
