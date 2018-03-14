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

    @Autowired
    UserRepository userRepository;

    @Test
    public void loginUser() throws Exception {
//        User user = new User("Ari", "fff", "f6ssghjk", "eee34", false);
//        userService.registrationUser(user);
//        User user1 = userService.loginUser("f6ssghjk", "eee34" );
//        assertThat(user1.getPassword(), is(user.getPassword()));
//        logger.info("User " + user.getId() + " was loggined.");
//        System.out.printf(user.toString());
    }


    @Test
    public void buyProduct() throws Exception {

        Product byId = productRepository.getById(6L);
        User byId1 = userRepository.getByEmail("ArihaU@yandex.ru");
        userService.buyProduct(byId1, byId);
        logger.info("Product " + byId.getId() + " was sold.");

    }
}
