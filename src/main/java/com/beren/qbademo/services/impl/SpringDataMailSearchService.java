package com.beren.qbademo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beren.qba.QueryGenerator;
import com.beren.qba.dsl.DslQueryGenerator;
import com.beren.qbademo.db.MailRepository;
import com.beren.qbademo.entities.Mail;
import com.beren.qbademo.rest.dtos.MailSearchDTO;
import com.beren.qbademo.services.MailSearchService;
import com.google.common.collect.Lists;

@Service
public class SpringDataMailSearchService implements MailSearchService {
	private QueryGenerator<Mail> queryGenerator = new DslQueryGenerator<>(Mail.class);
	@Autowired
	private MailRepository repository;

	@Override
	public List<Mail> search(MailSearchDTO dto) {
		ArrayList<Mail> temp = Lists.newArrayList(repository.findAll());
		// return Lists.newArrayList(repository
		// .findAll(queryGenerator.createQuery(dto,
		// queryGenerator.getEntityPath(QMail.mail.toString()))));

		return temp;
	}

}
