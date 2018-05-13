package modelTest;

import config.PreTestConfig;
import mining.Application;
import mining.model.Product;
import mining.model.User;
import mining.persistence.ProductRepository;
import mining.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
//@SpringBootTest(classes = Application.class)
public class ProductTest extends PreTestConfig {

    private Logger logger = LoggerFactory.getLogger(ProductTest.class);

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UserRepository userRepository;

    @Test
    public void getListProduct(){
        //Test is correct
//        Product product = new Product("Book", 12.44, "sold");
//        Product prod1 = productRepository.save(product);
//        logger.info("Product " + product.getId() + " was saved.");

//        assertThat(productRepository.getById(5L).getNameProduct(), is("Book"));
    }

}
