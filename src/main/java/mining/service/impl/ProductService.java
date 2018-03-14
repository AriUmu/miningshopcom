package mining.service.impl;

import mining.model.Product;
import mining.persistence.ProductRepository;
import mining.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceInterface{

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        Product product1 = productRepository.getById(product.getId());
        product1.setStatus(product.getStatus());
        product1.setPrice(product.getPrice());
        product1.setNameProduct(product.getNameProduct());
        Product save = productRepository.save(product1);
        return save;
    }

    public boolean deleteProduct(Product product) {
        productRepository.delete(product);
        return true;
    }
}
