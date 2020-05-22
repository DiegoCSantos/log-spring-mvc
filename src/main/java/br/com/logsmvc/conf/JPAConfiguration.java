package br.com.logsmvc.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean  entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		
		DriverManagerDataSource driverDatasource = new DriverManagerDataSource();
		driverDatasource.setDriverClassName("org.h2.Driver");
		driverDatasource.setUrl("jdbc:h2:~/database/logdb2;DB_CLOSE_ON_EXIT=FALSE");
		driverDatasource.setUsername("sa");
		driverDatasource.setPassword("");
		
		factoryBean.setDataSource(driverDatasource);
		Properties jpaProperties = new Properties();
		
		jpaProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		jpaProperties.put("hibernate.hbm2ddl.auto","update");
		jpaProperties.put("hibernate.show_sql","true");
		jpaProperties.put("hibernate.sql_format","true");
	    
		factoryBean.setPackagesToScan("br.com.logsmvc.model");
		factoryBean.setJpaProperties(jpaProperties );
		
		return factoryBean;
	}
	
	@Bean
	JpaTransactionManager  jpaTransactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
