package com.beren.qbademo.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.beren.qbademo.QbaDemoApplication;
import com.beren.qbademo.entities.Mail;
import com.beren.qbademo.rest.dtos.MailSearchDTO;
import com.beren.qbademo.services.MailSearchService;
import com.beren.qbademo.testconfigurations.MockitoMockService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { QbaDemoApplication.class, MockitoMockService.class })
public class MailControllerTest {

	private static final String SEARCH_MAIL_SERVICE = "/mails";

	private static final String NOTEXISTING_SENDER = UUID.randomUUID().toString() + "@email.com";

	private static final String EXISTING_SENDER = "mail@mail.com";

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MailSearchService searchService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		Mockito.reset(searchService);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void whenNotExistingMailReturnNotFound() throws Exception {
		givenMailNotFound();
		mockMvc.perform(get(SEARCH_MAIL_SERVICE).param("from", NOTEXISTING_SENDER)).andExpect(status().isNotFound());
	}

	@Test
	public void whenExceptionReturnInternalServerError() throws Exception {
		givenSearchException();
		mockMvc.perform(get(SEARCH_MAIL_SERVICE)).andExpect(status().isInternalServerError());
	}

	@Test
	public void whenMailExistsListOfMailsIsConvertedToJson() throws Exception {
		givenMailFound();
		mockMvc.perform(get(SEARCH_MAIL_SERVICE)).andExpect(status().isOk())
				.andExpect((jsonPath("$", Matchers.hasSize(1))));
	}

	@Test
	public void whenParameterIsProvidedPopulateDTO() throws Exception {
		String sender = EXISTING_SENDER;
		mockMvc.perform(get(SEARCH_MAIL_SERVICE).param("from", sender));
		thenDtoIsPopulated(sender);
	}

	private void givenSearchException() {
		Mockito.when(searchService.search(Mockito.any(MailSearchDTO.class))).thenThrow(new RuntimeException());
	}

	private void givenMailFound() {
		Mockito.when(searchService.search(Mockito.any(MailSearchDTO.class)))
				.thenReturn(Arrays.asList(new Mail("", "", "", "", "", "", new Date())));
	}

	private void givenMailNotFound() {
		Mockito.when(searchService.search(Mockito.any(MailSearchDTO.class))).thenReturn(new ArrayList<>());
	}

	private void thenDtoIsPopulated(String sender) {
		ArgumentCaptor<MailSearchDTO> argument = ArgumentCaptor.forClass(MailSearchDTO.class);
		Mockito.verify(searchService).search(argument.capture());
		assertThat(argument.getValue().getFrom(), is(sender));
	}
}
