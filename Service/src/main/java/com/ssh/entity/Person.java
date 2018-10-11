package com.ssh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Table;

/** 
* Web Service传输User信息的DTO.*  
* 只传输外部接口需要的属性.使用JAXB 2.0的annotation标注JAVA-XML映射,尽量使用默认约定.*  
* @XmlRootElement指定User为XML的根元素。User类的属性默认指定映射为@XmlElement。 
* @XmlElement用来定义XML中的子元素。 
* @XmlType-映射一个类或一个枚举类型成一个XML Schema类型 
*/  



@Entity
@Table(appliesTo = "Person")
@XmlRootElement  
@XmlType(name = "Person", namespace = "http://person.ssh.com") 
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Start")
    private String start;

    @Column(name = "End")
    private String end;

    @Column(name = "Location")
    private String location;

    @Column(name = "PrintTime")
    private String printTime;

    @Column(name = "Room")
    private String room;
	
    @Column(name = "Folio")
    private Long folio;
    
    @Column(name = "days")
    private String days;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start2) {
		this.start = start2;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end2) {
		this.end = end2;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrintTime() {
		return printTime;
	}

	public void setPrintTime(String printTime2) {
		this.printTime = printTime2;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room2) {
		this.room = room2;
	}

	public Long getFolio() {
		return folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days2) {
		this.days = days2;
	}
    
    
}
