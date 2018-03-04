package modelTest;

import mining.config.ApplicationConfig;
import mining.model.Product;
import mining.model.User;
import mining.persistence.ProductRepository;
import mining.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ProductTest {

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
        Set<User> setOfUser = new HashSet<User>();
        product.setUsers(setOfUser);
        productRepository.save(product);
        logger.info("Product " + product.getId() + " was saved.");


        User user = new User();
        user.setFirstName("Ari");
        user.setLastName("Um");
        user.setEmail("Ariha@yandex.ru");
        user.setPassword("1234");
        userRepository.save(user);
        logger.info("User " + user.getId() + " was saved.");

        Set<Product> setOfProduct = new HashSet<Product>();
        setOfProduct.add(productRepository.getById(1L));
        Iterator iterator = setOfProduct.iterator();
        System.out.println(iterator.next());

        user.setProduct(setOfProduct);
        userRepository.save(user);
        System.out.printf(user.toString());

        assertTrue(userRepository.getByEmail("Ariha@yandex.ru").getProducts().contains(product));
    }
}
