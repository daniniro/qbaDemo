package com.beren.qbademo.db;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beren.qbademo.entities.Mail;

@Repository
public interface MailRepository extends CrudRepository<Mail, Long>, QueryDslPredicateExecutor<Mail> {

}
