package serviceTest;

import mining.Application;
import mining.model.Product;
import mining.model.User;
import mining.persistence.ProductRepository;
import mining.persistence.UserRepository;
import mining.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService userService;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void loginUser() throws Exception {
        User user = new User();
        user.setFirstName("Ari");
        user.setLastName("Um");
        user.setEmail("ArihaUm@yandex.ru");
        user.setPassword("1234");
        user.setIsAdmin(false);
        userService.registrationUser(user);
        User user1 = userService.loginUser(user);
        assertThat(user1.getPassword(), is(user.getPassword()));
//        logger.info("User " + user.getId() + " was loggined.");
        System.out.printf(user.toString());

    }


    @Test
    public void buyProduct() throws Exception {
        User user = new User();
        user.setFirstName("Ari");
        user.setLastName("Um");
        user.setEmail("example@yandex.ru");
        user.setPassword("1234");
        user.setIsAdmin(false);
        userService.registrationUser(user);
        User user1 = userService.loginUser(user);

        Product product = new Product();
        product.setNameProduct("Book");
        product.setPrice(12.44);
        product.setStatus("sold");
        Product product1 = productRepository.save(product);
        logger.info("Product " + product.getId() + " was saved.");


        userService.buyProduct(user1,product1);
        logger.info("Product " + product1.getId() + " was sold.");

    }
}
