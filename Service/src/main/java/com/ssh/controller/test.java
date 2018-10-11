package com.ssh.controller;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssh.entity.Person;
import com.ssh.entity.Resume;
import com.ssh.entity.Users;
import com.ssh.service.PersonService;


@Controller
public class test {

	@Autowired
	private PersonService PersonService ;
	@Test
	public void test() {
		
		
		Date date = new Date();
		System.out.println(date);
		/*PointsAccount p = new PointsAccount();
		p.setACCOUNT_START_DTTM(date);
		p.setCREATED_BY_ID("1");
		p.setCREATED_DTTM(date);
		p.setLAST_UPDATED_BY_ID("1");
		p.setLAST_UPDATED_DTTM(date);
		p.setPARTNER_COMPANY_ID(1);
		p.setPARTNER_MEMBERSHIP_ID("11");
		p.setPOINTS_ACCOUNT_ID(1);
		p.setPOINTS_ACCOUNT_TYPE_CD("1");
		p.setPROGRAM_ID(1);
		p.setSTATUS_ID(1);
		p.setMEMBERSHIP_ID(12);
		membership m = new membership();
		m.setMEMBERSHIP_ID(1);
		m.setADDRESS("2323");
		m.setINITIAL_DTTM(date);
		m.setCELL_PHONE("11111");
		m.setCREATED_BY_ID("dfdfd");
		m.setCREATED_DTTM(date);
		m.setEMAIL("@qq,com");
		m.setENTERPRISE_CD("dfdfd");
		m.setEXTERNAL_MEMBERSHIP_ID("dfdfd");
		m.setFIRST_NAME("zibo");
		m.setINITIAL_DTTM(date);
		m.setLAST_NAME("liu");
		m.setLAST_UPDATED_BY_ID("1");
		m.setLAST_UPDATED_DTTM(date);
		m.setMEMBER_TYPE_ID(1);
		m.setMEMBERSHIP_NUM("11");
		m.setPRODUCT_LINE_ID(1);
		m.setSOURCE_COMPANY_ID(12);
		m.setSTATUS_ID(1);
		
		
	
		p.setMembershipVo(m);
		
		MembershipService.postMembership(m);*/
		
	
		
		List<Person> plist = PersonService.findAll();
	
       for (Person person : plist) {
    	  System.out.println(person.getName());
	}
	}

}
