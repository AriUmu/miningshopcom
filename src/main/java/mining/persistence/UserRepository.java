package mining.persistence;

import mining.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByFirstName(String name);
    User getByEmail(String login) throws NullPointerException;
    void deleteByFirstName(String name);
    List<User> findAll();

}