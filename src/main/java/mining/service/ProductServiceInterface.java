package mining.service;

import mining.model.Product;

public interface ProductServiceInterface {

    Product createProduct(Product product);

    Product updateProduct(Product product);

    boolean deleteProduct(Product product);

}
