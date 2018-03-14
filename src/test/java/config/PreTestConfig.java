package config;

import mining.config.DataSourceConfig;
import mining.config.PersistenceConfig;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {PersistenceConfig.class, DataSourceConfig.class})
public class PreTestConfig {

    @BeforeClass
    public static void setup() {

    }
}