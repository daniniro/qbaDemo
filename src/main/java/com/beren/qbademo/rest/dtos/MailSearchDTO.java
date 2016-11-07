package com.beren.qbademo.rest.dtos;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	private String[] to;
	@QueryStartsWith("subject")
	private String subject;
	@DateTimeFormat(iso = ISO.DATE)
	@QueryGreaterThan(value = "dateInsert", isInclusive = true)
	private Date dateFrom;
	@DateTimeFormat(iso = ISO.DATE)
	@QueryLessThan(value = "dateInsert", isInclusive = true)
	private Date dateTo;
	@QueryContains(value = "body", ignoreCase = true)
	private String body;

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = StringUtils.trimToNull(from);
	}

	public void setTo(String[] to) {
		if (to != null && to.length > 0)
			this.to = Arrays.copyOf(to, to.length);

	}

	public void setSubject(String subject) {
		this.subject = StringUtils.trimToNull(subject);

	}

	public void setDateFrom(Date dateFrom) {
		if (dateFrom != null)
			this.dateFrom = new Date(dateFrom.getTime());

	}

	public void setDateTo(Date dateTo) {
		if (dateTo != null) {
			this.dateTo = new Date(dateTo.getTime());
		}

	}

	public void setBody(String body) {
		this.body = StringUtils.trimToNull(body);

	}

	public String[] getTo() {
		return Arrays.copyOf(to, to.length);
	}

	public String getSubject() {
		return subject;
	}

	public Date getDateFrom() {
		return new Date(dateFrom.getTime());
	}

	public Date getDateTo() {
		return new Date(dateTo.getTime());
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
