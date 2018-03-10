package mining.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;


//    @Value("${dbSQLSchema}")
//    private Resource dbSQLSchema;
//
//    @Value("${dbSQLTestData}")
//    private Resource dbSQLTestData;

    @Value("${hibernateDialect}")
    private String hibernateDialect;

    @Value("${showSQL}")
    private String showSQL;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();

        hibernateProp.put("hibernate.dialect", hibernateDialect);
        hibernateProp.put("hibernate.hbm2ddl.auto", "update");
        hibernateProp.put("hibernate.show_sql", showSQL);
        hibernateProp.put("hibernate.format_sql", true);

        return hibernateProp;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(dbUser);
        ds.setPassword(dbPassword);

        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.addScript(dbSQLSchema);
//        populator.addScript(dbSQLTestData);
        DatabasePopulatorUtils.execute(populator, ds);

        return ds;
    }
}