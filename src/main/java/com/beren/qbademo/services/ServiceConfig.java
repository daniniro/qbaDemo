package com.beren.qbademo.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beren.qba.QueryGenerator;
import com.beren.qba.dsl.DslQueryGenerator;
import com.beren.qbademo.entities.Mail;

@Configuration
public class ServiceConfig {
	@Bean
	public QueryGenerator<Mail> queryGenerator() {
		return new DslQueryGenerator<>(Mail.class);
	}
}
