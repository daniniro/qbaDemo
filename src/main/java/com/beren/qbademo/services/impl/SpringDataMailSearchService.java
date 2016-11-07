package com.beren.qbademo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beren.qba.QueryGenerator;
import com.beren.qbademo.db.MailRepository;
import com.beren.qbademo.entities.Mail;
import com.beren.qbademo.entities.QMail;
import com.beren.qbademo.rest.dtos.MailSearchDTO;
import com.beren.qbademo.services.MailSearchService;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;

@Service
public class SpringDataMailSearchService implements MailSearchService {
	private QueryGenerator<Mail> queryGenerator;
	private MailRepository repository;

	@Autowired
	public SpringDataMailSearchService(QueryGenerator<Mail> queryGenerator, MailRepository repository) {
		super();
		this.queryGenerator = queryGenerator;
		this.repository = repository;
	}

	@Override
	public List<Mail> search(MailSearchDTO dto) {
		return Lists.newArrayList(repository.findAll(queryGenerator.createQuery(dto, queryGenerator.getEntityPath(QMail.mail.toString()))));

	}

}
