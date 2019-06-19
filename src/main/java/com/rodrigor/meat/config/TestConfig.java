package com.rodrigor.meat.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodrigor.meat.services.DbServiceTest;



@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DbServiceTest dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		
		dbService.instantiateTestDatabase();
		return true;
	}

}
