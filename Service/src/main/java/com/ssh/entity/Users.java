package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Table;


@Entity
@Table(appliesTo = "Users")
public class Users {
	 //员工id
	@Id
    @GeneratedValue
    private Integer userid;
    //员工姓名
	@Column(name = "username")
    private String username;
    //员工密码
	@Column(name = "userpass")
    private String userpass;
    //档案对象
	@OneToOne
    private Resume resume;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
}
