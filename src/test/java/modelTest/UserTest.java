package modelTest;

import config.DataSourceConfigTest;
import config.PreTestConfig;
import mining.model.User;
import mining.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest  extends PreTestConfig {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfigTest.class);
    @Autowired
    public UserRepository userRepository;

    @Test
    public void getByName() {
//                User user = new User("Ari", "fff", "ffff", "eee334", false);
//                userRepository.save(user);
                User one = userRepository.getByEmail("test211@test.com");
//                assertThat(one.getFirstName(), is("test2"));
            }
}
