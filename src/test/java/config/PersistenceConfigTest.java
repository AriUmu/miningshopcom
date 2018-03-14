package config;

import mining.config.DataSourceConfig;
import mining.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, DataSourceConfig.class})
public class PersistenceConfigTest extends PreTestConfig{
    @Autowired
    PersistenceConfig persistenceConfig;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    PersistenceUnitManager persistenceUnitManager;

    @Autowired
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor;

    @Test
    public void eansCreatedTest() {
        assertNotNull(persistenceConfig);
        assertNotNull(entityManagerFactory);
        assertNotNull(persistenceUnitManager);
        assertNotNull(persistenceExceptionTranslationPostProcessor);
    }
}
