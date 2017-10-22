package com.equitativa.configuration;
 
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.equitativa")
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
 
    @Autowired
    private Environment environment;
 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.equitativa" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
     
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
     
    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter(){
    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    	vendorAdapter.setGenerateDdl(false);
    	vendorAdapter.setShowSql(true);
    	return vendorAdapter;
    }
    
    @Bean
    public ResourceDatabasePopulator dbInit(){
    	ResourceDatabasePopulator dbpopulator = new ResourceDatabasePopulator();
    	dbpopulator.addScripts(new ClassPathResource("db_script.sql"));
    	dbpopulator.setContinueOnError(false);
    	return dbpopulator;
    }
    
    @Bean
    public DataSourceInitializer startupScripts(){
    	DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
    	dataSourceInitializer.setDataSource(dataSource());
    	dataSourceInitializer.setDatabasePopulator(dbInit());
    	dataSourceInitializer.setEnabled(true);
    	return dataSourceInitializer;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    	LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    	entityManagerFactory.setDataSource(dataSource());
    	entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
    	entityManagerFactory.setPackagesToScan("com.equitativa");
    	return entityManagerFactory;
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;        
    }
     
    @Bean
    public JpaTransactionManager transactionManager() {
    	JpaTransactionManager txManager = new JpaTransactionManager();
    	txManager.setEntityManagerFactory(entityManagerFactory().getNativeEntityManagerFactory());
        return txManager;
    }
}