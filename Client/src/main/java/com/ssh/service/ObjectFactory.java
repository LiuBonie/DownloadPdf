
package com.ssh.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.ssh.person.Person;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ssh.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindAllResponse_QNAME = new QName("http://service.ssh.com/", "findAllResponse");
    private final static QName _SaveOrUpdate_QNAME = new QName("http://service.ssh.com/", "saveOrUpdate");
    private final static QName _FindById_QNAME = new QName("http://service.ssh.com/", "FindById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://service.ssh.com/", "FindByIdResponse");
    private final static QName _SaveOrUpdateResponse_QNAME = new QName("http://service.ssh.com/", "saveOrUpdateResponse");
    private final static QName _Person_QNAME = new QName("http://service.ssh.com/", "person");
    private final static QName _DeleteResponse_QNAME = new QName("http://service.ssh.com/", "deleteResponse");
    private final static QName _Flush_QNAME = new QName("http://service.ssh.com/", "flush");
    private final static QName _SavePersonResponse_QNAME = new QName("http://service.ssh.com/", "savePersonResponse");
    private final static QName _Delete_QNAME = new QName("http://service.ssh.com/", "delete");
    private final static QName _FindAll_QNAME = new QName("http://service.ssh.com/", "findAll");
    private final static QName _FlushResponse_QNAME = new QName("http://service.ssh.com/", "flushResponse");
    private final static QName _SavePerson_QNAME = new QName("http://service.ssh.com/", "savePerson");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ssh.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SavePerson }
     * 
     */
    public SavePerson createSavePerson() {
        return new SavePerson();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FlushResponse }
     * 
     */
    public FlushResponse createFlushResponse() {
        return new FlushResponse();
    }

    /**
     * Create an instance of {@link SavePersonResponse }
     * 
     */
    public SavePersonResponse createSavePersonResponse() {
        return new SavePersonResponse();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link SaveOrUpdateResponse }
     * 
     */
    public SaveOrUpdateResponse createSaveOrUpdateResponse() {
        return new SaveOrUpdateResponse();
    }

    /**
     * Create an instance of {@link Flush }
     * 
     */
    public Flush createFlush() {
        return new Flush();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link SaveOrUpdate }
     * 
     */
    public SaveOrUpdate createSaveOrUpdate() {
        return new SaveOrUpdate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveOrUpdate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "saveOrUpdate")
    public JAXBElement<SaveOrUpdate> createSaveOrUpdate(SaveOrUpdate value) {
        return new JAXBElement<SaveOrUpdate>(_SaveOrUpdate_QNAME, SaveOrUpdate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "FindById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "FindByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveOrUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "saveOrUpdateResponse")
    public JAXBElement<SaveOrUpdateResponse> createSaveOrUpdateResponse(SaveOrUpdateResponse value) {
        return new JAXBElement<SaveOrUpdateResponse>(_SaveOrUpdateResponse_QNAME, SaveOrUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flush }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "flush")
    public JAXBElement<Flush> createFlush(Flush value) {
        return new JAXBElement<Flush>(_Flush_QNAME, Flush.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "savePersonResponse")
    public JAXBElement<SavePersonResponse> createSavePersonResponse(SavePersonResponse value) {
        return new JAXBElement<SavePersonResponse>(_SavePersonResponse_QNAME, SavePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlushResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "flushResponse")
    public JAXBElement<FlushResponse> createFlushResponse(FlushResponse value) {
        return new JAXBElement<FlushResponse>(_FlushResponse_QNAME, FlushResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ssh.com/", name = "savePerson")
    public JAXBElement<SavePerson> createSavePerson(SavePerson value) {
        return new JAXBElement<SavePerson>(_SavePerson_QNAME, SavePerson.class, null, value);
    }

}
