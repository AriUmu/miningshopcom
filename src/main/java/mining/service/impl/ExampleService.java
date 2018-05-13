package mining.service.impl;

import mining.model.Example;
import mining.persistence.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    ExampleRepository exampleRepository;


    private void save(){
        Example example = new Example(1, 4, 5);
        exampleRepository.save(example);
        Example example2 = new Example(1, 6, 9);
        exampleRepository.save(example2);
        Example example3 = new Example(1, 9, 10);
        exampleRepository.save(example3);
    }
}
