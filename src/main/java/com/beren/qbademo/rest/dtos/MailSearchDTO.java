package com.beren.qbademo.rest.dtos;

import java.util.Date;
import java.util.List;

import com.beren.qba.annotations.QueryContains;
import com.beren.qba.annotations.QueryEq;
import com.beren.qba.annotations.QueryGreaterThan;
import com.beren.qba.annotations.QueryIs;
import com.beren.qba.annotations.QueryLessThan;
import com.beren.qba.annotations.QueryOneOf;
import com.beren.qba.annotations.QueryRefersTo;
import com.beren.qba.annotations.QueryStartsWith;
import com.beren.qbademo.entities.Mail;

@QueryRefersTo(Mail.class)
public class MailSearchDTO {
	@QueryIs("id")
	private Long id;
	@QueryEq("from")
	private String from;
	@QueryOneOf("to")
	private List<String> to;
	@QueryStartsWith("subject")
	private String subject;
	@QueryGreaterThan(value = "dateInsert", isInclusive = true)
	private Date dateFrom;
	@QueryLessThan(value = "dateInsert", isInclusive = true)
	private Date dateTo;
	@QueryContains(value = "body", ignoreCase = true)
	private String body;

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(List<String> to) {
		this.to = to;

	}

	public void setSubject(String subject) {
		this.subject = subject;

	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;

	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;

	}

	public void setBody(String body) {
		this.body = body;

	}

	public List<String> getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public String getBody() {
		return body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
