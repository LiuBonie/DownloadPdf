package com.ssh.dao.impl;

import com.ssh.dao.PersonDao;
import com.ssh.entity.Person;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("PersonDao")
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Person load(Long id) {
    	Session session = this.getCurrentSession();
    	Person person  = (Person)session.load(Person.class,id);
    	session.close();
        return person;
    }

    public Person get(Long id) {
    	Session session = this.getCurrentSession();
    	Person person  =  (Person)session.get(Person.class,id);
    	session.close();
        return person;
    }

    public List<Person> findAll() {
    	Session session = this.getCurrentSession();
    	@SuppressWarnings("unchecked")
		List<Person> acctUsers = session.createQuery("from Person").setCacheable(true).list();
    	session.close(); 
		return acctUsers;
    }

    public void persist(Person entity) {
    	Session session = this.getCurrentSession();
    	session.persist(entity);
    	session.close();
    }

    public Long save(Person entity) {
    	Session session = this.getCurrentSession();
    	Long num  = (Long)session.save(entity);
    	session.close();
        return num;
    }

    public void saveOrUpdate(Person entity) {
    	Session session = this.getCurrentSession();
    	Transaction tx = session.beginTransaction();
    	session.saveOrUpdate(entity);
    	tx.commit();
    }

    public void delete(Long id) {	
    	/*当load()了的时候开启了一个session,delete了的时候又开启了一个session.
    	报错org.hibernate.HibernateException: Illegal attempt to associate a collection with two open sessions*/
        /*Person person = load(id);
        getCurrentSession().delete(person);*/
    	Session session = this.getCurrentSession();
        String hql = "delete from Person where id = :id";
    	Query query = session.createQuery(hql);
    	query.setParameter("id",id);
    	query.executeUpdate();
    	session.close();
    }
    
    
    public void flush() {
        getCurrentSession().flush();;
    }
}
