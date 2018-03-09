package modelTest;

import mining.Application;
import mining.model.User;
import mining.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Autowired
    public UserRepository userRepository;

    @Test
    public void getByName() {
                User user = new User();
                user.setFirstName("Arina");
                user.setLastName("Um");
                user.setEmail("ArihaU@yandex.ru");
                user.setPassword("1234");
                userRepository.save(user);
                User one = userRepository.getByEmail("ArihaU@yandex.ru");
                assertThat(one.getFirstName(), is("Arina"));
            }
}
