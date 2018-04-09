package com.alex.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("com.alex.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	@Autowired
        private Environment env;
        
        private Logger logger = Logger.getLogger(getClass().getName());
        
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
        
        @Bean
        public DataSource securityDataSource(){
            
            com.mchange.v2.c3p0.ComboPooledDataSource securityDataSource = new com.mchange.v2.c3p0.ComboPooledDataSource();
                    
            try {
                securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
            } catch (PropertyVetoException exc) {
                throw new RuntimeException(exc);
            }
      
            logger.info(">>> jdbc.url= " + env.getProperty("jdbc.url"));
            logger.info(">>> jdbc.user= " + env.getProperty("jdbc.user"));
            
            securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            securityDataSource.setUser(env.getProperty("jdbc.user"));
            securityDataSource.setPassword(env.getProperty("jdbc.password"));
                       
            securityDataSource.setMinPoolSize(getIntProperty("connection."
                    + "pool.minPoolSize"));
             securityDataSource.setMaxPoolSize(getIntProperty("connection."
                    + "pool.maxPoolSize"));
              securityDataSource.setMaxIdleTime(getIntProperty("connection."
                    + "pool.maxIdleTime"));
               securityDataSource.setInitialPoolSize(getIntProperty("connection."
                    + "pool.initialPoolSize"));
            
            return securityDataSource;
        }
        
            private int getIntProperty(String propName){
                
                String propVal = env.getProperty(propName);
                
                int intPropVal = Integer.parseInt(propVal);
                
                return intPropVal;      
            }   
       
           @Bean
           public LocalSessionFactoryBean sessionFactory() throws IOException {
           Resource config = new ClassPathResource("hibernate.cfg.xml");
           LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
           sessionFactory.setConfigLocation(config);
           sessionFactory.setPackagesToScan(
           new String[] { "com.alex.springsecurity.demo.entities"});
           sessionFactory.setDataSource(securityDataSource());
           return sessionFactory;
        }            
    
        @Bean
        @Autowired
        public HibernateTransactionManager transactionManager(
          SessionFactory sessionFactory) {

           HibernateTransactionManager txManager
            = new HibernateTransactionManager();
           
           txManager.setSessionFactory(sessionFactory);

           return txManager;
        }
}