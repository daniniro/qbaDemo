package com.beren.qbademo.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MAIL")
public class Mail {

	private Long id;
	private String from;
	private String to;
	private String bcc;
	private String subject;
	private String body;
	private Date dateInsert;

	protected Mail() {
		super();
	}

	public Mail(String from, String to, String bcc, String subject, String body, String message, Date dateInsert) {
		this();
		this.from = from;
		this.to = to;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;
		this.dateInsert = new Date(dateInsert.getTime());

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_MAIL")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SENDER", nullable = false)
	public String getFrom() {
		return this.from;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATE_INSERT", nullable = false)
	public Date getDateInsert() {
		return new Date(this.dateInsert.getTime());
	}

	@Column(name = "SUBJECT", nullable = true)
	public String getSubject() {
		return this.subject;
	}

	@Column(name = "RECIPIENT", nullable = false)
	public String getTo() {
		return this.to;
	}

	@Column(name = "BCC_RECIPIENT", nullable = false)
	public String getBcc() {
		return this.bcc;
	}

	@Column(name = "BODY", nullable = true)
	public String getBody() {
		return this.body;
	}

	protected void setFrom(String from) {
		this.from = from;
	}

	protected void setTo(String to) {
		this.to = to;
	}

	protected void setBcc(String bcc) {
		this.bcc = bcc;
	}

	protected void setSubject(String subject) {
		this.subject = subject;
	}

	protected void setBody(String body) {
		this.body = body;
	}

	protected void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

}
