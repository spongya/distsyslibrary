package com.uni.iit.distsys.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.uni.iit.distsys.controller.LibraryController;
import com.uni.iit.distsys.core.service.LibraryManagerService;
import com.uni.iit.distsys.core.service.LibrarySearchService;
import com.uni.iit.distsys.dao.dummy.LibraryDAODummy;
import com.uni.iit.distsys.service.dao.LibraryDAO;
import com.uni.iit.distsys.service.impl.LibraryManagerServiceImpl;
import com.uni.iit.distsys.service.impl.LibrarySearchServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.uni.iit.distsys.controller")
public class AppConfig {
	
	@Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
	
	@Bean
	public LibraryDAO libraryDAO() {
		return new LibraryDAODummy();
	}
	
	@Bean
	public LibraryManagerService libraryManagerService() {
		return new LibraryManagerServiceImpl(libraryDAO());
	}
	
	@Bean
	public LibrarySearchService librarySearchService() {
		return new LibrarySearchServiceImpl(libraryDAO());
	}
	
	@Bean
	public LibraryController libraryController() {
		return new LibraryController(libraryManagerService(), librarySearchService());
	}
}
