package com.beren.qbademo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.beren.qbademo.entities.Mail;
import com.beren.qbademo.rest.dtos.MailSearchDTO;
import com.beren.qbademo.services.MailSearchService;

@RestController
@RequestMapping(value = "/mails")
public class MailController {
	public static class ResourceNotFoundException extends Exception {
		private static final long serialVersionUID = -4970600526575168411L;
	}

	private MailSearchService searchService;

	@Autowired
	private MailController(MailSearchService searchService) {
		this.searchService = searchService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Mail> list(MailSearchDTO dto) throws ResourceNotFoundException {
		List<Mail> ret = searchService.search(dto);
		if (ret.isEmpty())
			throw new ResourceNotFoundException();
		return ret;
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	protected ResponseEntity<Object> handleException(ResourceNotFoundException ex, WebRequest request) {
		return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	}

}
