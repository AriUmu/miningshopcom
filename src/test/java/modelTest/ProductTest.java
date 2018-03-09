package modelTest;

import mining.config.ApplicationConfig;
import mining.model.Product;
import mining.model.User;
import mining.persistence.ProductRepository;
import mining.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ProductTest {

    private Logger logger = LoggerFactory.getLogger(ProductTest.class);

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UserRepository userRepository;

    @Test
    public void getListProduct(){
        Product product = new Product();
        product.setNameProduct("Book");
        product.setPrice(12.44);
        product.setStatus("sold");
        Product prod1 = productRepository.save(product);
        logger.info("Product " + product.getId() + " was saved.");


        User user = new User();
        user.setFirstName("Ari");
        user.setLastName("Um");
        user.setEmail("Ariha@yandex.ru");
        user.setPassword("1234");
        User user1 = userRepository.save(user);
        logger.info("User " + user.getId() + " was saved.");

        HashSet<Long> set = new HashSet<>();
        set.add(prod1.getId());
        user1.getProduct().add(prod1.getId());
        User user2 = userRepository.save(user1);

        prod1.getUsers().add(user1.getId());
        productRepository.save(prod1);

        System.out.println(user2.toString());
        assertTrue(userRepository.getByEmail("Ariha@yandex.ru").getProducts().contains(product.getId()));

    }

}
