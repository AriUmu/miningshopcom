package config;

import mining.config.DataSourceConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
public class DataSourceConfigTest extends PreTestConfig{

    private Logger logger = LoggerFactory.getLogger(DataSourceConfigTest.class);

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Autowired
    Properties hibernateProperties;

    @Autowired
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer;

    @Autowired
    DataSource dataSource;

    @Test
    public void beansCreatedTest() {
        assertNotNull(dataSourceConfig);
        assertNotNull(propertySourcesPlaceholderConfigurer);
        assertNotNull(hibernateProperties);
        assertNotNull(dataSource);

        logger.info("hibernate.show_sql -> " + hibernateProperties.get("hibernate.show_sql"));
    }
}