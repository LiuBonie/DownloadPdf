package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "Resume")
public class Resume {
	 //档案id
	@Id
    @GeneratedValue
    private Integer resid;
    //档案名称
	@Column(name = "resname")
    private String resname;
    
	//档案编号
	@Column(name = "rescardno")
    private String rescardno;
    //员工对象
	
	@ManyToOne
	@JoinColumn(name="userid",unique=true)
    private Users users;
	
	public Integer getResid() {
		return resid;
	}
	public void setResid(Integer resid) {
		this.resid = resid;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public String getRescardno() {
		return rescardno;
	}
	public void setRescardno(String rescardno) {
		this.rescardno = rescardno;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
}
