package modelTest;

import mining.config.ApplicationConfig;
import mining.model.User;
import mining.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserTest {

    @Autowired
    public UserRepository userRepository;

    @Test
    public void getByName() {
                User user = new User();
                user.setFirstName("Ari");
                user.setLastName("Um");
                user.setEmail("Ariha@yandex.ru");
                user.setPassword("1234");
                System.out.printf(user.toString());
                userRepository.save(user);
                User one = userRepository.getByFirstName("Ari");
                assertThat(one.getFirstName(), is("Ari"));
            }
}
