package com.beren.qbademo.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beren.qbademo.entities.Mail;

@Repository
@Transactional
public interface MailRepository extends CrudRepository<Mail, Long> {

}
