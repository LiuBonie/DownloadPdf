package com.ssh.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ssh.entity.Person;

@WebService(name = "PersonService") 
public interface PersonService {
	@WebMethod 
    Long savePerson(Person person);
	@WebMethod 
    List<Person> findAll();
	@WebMethod 
    Person FindById(Long id);
	@WebMethod 
    void delete(Long id);
	@WebMethod 
    void saveOrUpdate(Person person);
	@WebMethod 
    void flush() ;
}
