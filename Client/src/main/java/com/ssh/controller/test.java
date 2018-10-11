package com.ssh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.ssh.person.Person;
import com.ssh.service.PersonService;
import com.ssh.service.PersonServiceImplService;

public class test {
//	public static void main(String[] args) {
//		SimpleDateFormat aa = new SimpleDateFormat("yyyy-MM-dd KK:mm aa",Locale.ENGLISH);
//		String time = aa.format(new Date());
//		System.out.println(time);
//	}
	public static void main(String[] args) {
		//获取PersonService
//		PersonServiceImplService psi = new PersonServiceImplService();
//		PersonService psiS = psi.getPersonServiceImplPort();
		//another way 需要导包cxf-rt-frontend-jaxrs（好像这个）
	/*	PersonService PersonService = JAXRSClientFactory  
		            .create("http://localhost:8081/sshTO/cxf/testService",   
		            		PersonService.class); */

		   JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

	       factory.setServiceClass(PersonService.class);

	    factory.setAddress("http://localhost:8081/sshTO/cxf/testService?wsdl");

	    PersonService client = (PersonService) factory.create();	
		List<Person> list = client.findAll();
		for (Person object : list) {
			System.out.println(object.getName());
		}
}
}
