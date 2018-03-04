package serviceTest;

import mining.config.ApplicationConfig;
import mining.model.User;
import mining.persistence.UserRepository;
import mining.service.impl.UserService;
import modelTest.UserTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserServiceTest {

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService userService;

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
        System.out.printf(user.toString());

    }
}
