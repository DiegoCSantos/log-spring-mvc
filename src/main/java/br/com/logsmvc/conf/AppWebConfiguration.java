package br.com.logsmvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.logsmvc.controller.HomeController;
import br.com.logsmvc.dao.PacoteDAO;
import br.com.logsmvc.service.LogService;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, PacoteDAO.class, LogService.class})
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}

}
