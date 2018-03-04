package mining.persistence;

import mining.model.Product;
import mining.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getById(Long id);
    List<Product> getAllByUsersOrderByNameProduct (User user);

}
