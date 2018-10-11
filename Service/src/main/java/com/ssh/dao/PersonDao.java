package com.ssh.dao;

import org.hibernate.Session;

import com.ssh.entity.Person;


public interface PersonDao extends DomainDao<Person,Long> {

	Session getCurrentSession();

}