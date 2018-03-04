package mining.service;

import mining.model.Product;
import mining.model.User;

public interface UserServiceInterface {

    User loginUser (User user) throws Exception;

    boolean isAdmin (User user);

    User registrationUser (User user);

    boolean buyProduct(User user, Product product);


}
