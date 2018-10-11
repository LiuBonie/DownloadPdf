package com.ssh.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.dao.PersonDao;
import com.ssh.entity.Person;
import com.ssh.service.PersonService;

@Service("PersonService")

@WebService(endpointInterface="com.ssh.service.PersonService",
			targetNamespace ="http://service.ssh.com")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

	public Long savePerson(Person person) {

		return personDao.save(person);
	}

	public List<Person> findAll() {
		
		return personDao.findAll();
	}
	//@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public void delete(Long id) {

		 personDao.delete(id);
	}

	public void saveOrUpdate(Person person) {

		personDao.saveOrUpdate( person);

	}
    
	public void flush() {
		personDao.flush();
		
	}

	public Person FindById(Long id) {
		Person person = personDao.get(id);
		return person;
	}

}
