package mining.persistence;

import mining.model.Product;
import mining.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByEmail(String login) throws NullPointerException;
    void deleteByFirstName(String name);
    List<User> findAll();

}