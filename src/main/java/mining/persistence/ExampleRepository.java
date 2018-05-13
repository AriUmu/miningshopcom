package mining.persistence;

import mining.model.Example;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface ExampleRepository extends CrudRepository<Example, Integer> {
}
