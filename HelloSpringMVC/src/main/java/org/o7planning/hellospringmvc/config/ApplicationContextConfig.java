package org.o7planning.hellospringmvc.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan("org.o7planning.hellospringmvc") 
@EnableTransactionManagement
public class ApplicationContextConfig { 
  
	@Autowired
	private Environment env;
      
 
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        System.out.print("viewResolver");
        return viewResolver;
    }
   
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
    	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    	sessionFactory.setDataSource(dataSource());
    	sessionFactory.setPackagesToScan("org.o7planning.hellospringmvc.model");
    	sessionFactory.setHibernateProperties(hibernateProperties());
    	 System.out.print("sessionFactory");
    	return sessionFactory;
    }
    private Properties hibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    	properties.put("hibernate.show_sql", "true");
    	 System.out.print("properties");
    	return properties;
	}

	@Bean(name = "dataResource")
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jspseverlet?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("Thanh2018");
		 System.out.print("dataResource");
		return dataSource;
	}
  
@Bean(name = "transactionManager")
  public HibernateTransactionManager transactionManager() {
	  HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
	  hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
	  System.out.print("transactionManager");
	  return hibernateTransactionManager;
  }
}