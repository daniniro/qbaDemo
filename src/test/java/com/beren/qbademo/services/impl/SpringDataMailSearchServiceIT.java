package com.beren.qbademo.services.impl;

import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beren.qbademo.rest.dtos.MailSearchDTO;
import com.beren.qbademo.services.ServiceConfig;
import com.beren.qbademo.testconfigurations.DbConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DbConfig.class, ServiceConfig.class, SpringDataMailSearchService.class })
public class SpringDataMailSearchServiceIT {

	private static final String FROM = "mail@mail.com";
	private static final String[] TO = { "dest1@mail.com", "dest2@mail.com" };
	private static final String SUBJECT = "test";
	private static final String BODY = "hello";
	private static final String MAIL_DATE = "2016-09-10";
	@Autowired
	private SpringDataMailSearchService searchService;

	@Test
	public void happyPath() throws Exception {
		MailSearchDTO dto = givenDto();
		assertThat(searchService.search(dto), Matchers.hasSize(1));
	}

	private MailSearchDTO givenDto() throws ParseException {
		MailSearchDTO dto = new MailSearchDTO();
		dto.setFrom(FROM);
		dto.setTo(Arrays.asList(TO));
		dto.setSubject(SUBJECT);
		dto.setDateFrom(new SimpleDateFormat("yyyy-MM-dd").parse(MAIL_DATE));
		dto.setBody(BODY);
		return dto;
	}

}
