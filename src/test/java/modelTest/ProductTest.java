package modelTest;

import config.PreTestConfig;
import mining.Application;
import mining.model.Product;
import mining.model.User;
import mining.persistence.ProductRepository;
import mining.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@SpringBootTest(classes = Application.class)
public class ProductTest extends PreTestConfig {

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
//        logger.info("User " + user.getId() + " was saved.");

        HashSet<Long> set = new HashSet<>();
        set.add(prod1.getId());
//        user1.getProduct().add(prod1.getId());
        User user2 = userRepository.save(user1);

//        prod1.getUsers().add(user1.getId());
        productRepository.save(prod1);

    }

}
