package com.beren.qbademo.services;

import java.util.List;

import com.beren.qbademo.entities.Mail;
import com.beren.qbademo.rest.dtos.MailSearchDTO;

public interface MailSearchService {

	List<Mail> search(MailSearchDTO dto);

}
