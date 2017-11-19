package com.uni.iit.distsys.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.uni.iit.distsys.controller.FineController;
import com.uni.iit.distsys.core.service.FineCalculatorManagerService;
import com.uni.iit.distsys.core.service.FineCalculatorSearchService;
import com.uni.iit.distsys.dao.dummy.FineDAODummy;
import com.uni.iit.distsys.service.dao.FineDAO;
import com.uni.iit.distsys.service.impl.FineCalculatorManagerServiceImpl;
import com.uni.iit.distsys.service.impl.FineCalculatorSearchServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.uni.iit.distsys.controller")
public class AppConfig {
	
	@Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
	
	@Bean
	public FineDAO fineDAO() {
		return new FineDAODummy(30, 200);
	}
	
	@Bean
	public FineCalculatorManagerService fineCalculatorManagerService() {
		return new FineCalculatorManagerServiceImpl(fineDAO());
	}
	
	@Bean
	public FineCalculatorSearchService fineCalculatorSearchService() {
		return new FineCalculatorSearchServiceImpl(fineDAO());
	}
	
	@Bean
	public FineController fineController() {
		return new FineController(fineCalculatorManagerService(), fineCalculatorSearchService());
	}
}
