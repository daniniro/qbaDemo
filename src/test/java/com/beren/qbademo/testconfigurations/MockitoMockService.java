package com.beren.qbademo.testconfigurations;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beren.qbademo.services.MailSearchService;

@Configuration
public class MockitoMockService {
	@Mock
	private MailSearchService searchService;

	public MockitoMockService() {
		MockitoAnnotations.initMocks(this);
	}

	@Bean
	public MailSearchService searchService() {
		return searchService;
	}

}
