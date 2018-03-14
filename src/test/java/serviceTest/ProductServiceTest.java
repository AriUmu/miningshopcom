package serviceTest;

import mining.Application;
import mining.model.Product;
import mining.persistence.ProductRepository;
import mining.service.impl.ProductService;
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
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void createProduct() {
        Product product = new Product("Book", 12.77, "sold");
        Product save = productService.createProduct(product);
        assertThat(save.getPrice(), is(12.77));
    }

    @Test
    public void updateProductServise(){
        Product byId = productRepository.getById(7L);
        byId.setNameProduct("book777");
        Product save = productService.updateProduct(byId);
        assertThat(save.getNameProduct(), is("book777"));
    }

    @Test
    public void deleteProductServise(){
//        Product byId = productRepository.getById(5L);
//        productService.deleteProduct(byId);
//        assertTrue(productRepository.getById(byId.getId()) == null);
    }
}
