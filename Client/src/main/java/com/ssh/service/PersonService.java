
package com.ssh.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.ssh.person.Person;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonService", targetNamespace = "http://service.ssh.com/")
@XmlSeeAlso({
    com.ssh.person.ObjectFactory.class,
    com.ssh.service.ObjectFactory.class
})
public interface PersonService {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "saveOrUpdate", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.SaveOrUpdate")
    @ResponseWrapper(localName = "saveOrUpdateResponse", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.SaveOrUpdateResponse")
    public void saveOrUpdate(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.ssh.person.Person
     */
    @WebMethod(operationName = "FindById")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "FindById", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.FindById")
    @ResponseWrapper(localName = "FindByIdResponse", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.FindByIdResponse")
    public Person findById(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "delete", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.DeleteResponse")
    public void delete(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @return
     *     returns java.util.List<com.ssh.person.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.FindAllResponse")
    public List<Person> findAll();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "savePerson", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.SavePerson")
    @ResponseWrapper(localName = "savePersonResponse", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.SavePersonResponse")
    public Long savePerson(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "flush", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.Flush")
    @ResponseWrapper(localName = "flushResponse", targetNamespace = "http://service.ssh.com/", className = "com.ssh.service.FlushResponse")
    public void flush();

}