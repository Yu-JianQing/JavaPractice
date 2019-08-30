package com.student;

import java.io.Serializable;

public class Student {
	private String sno;
	private String sname;
	private String sage;
	private String sex;
	
	public Student(){}
	public Student(String sno,String sname,String sage,String sex){
		this.sno=sno;this.sname=sname;this.sage=sage;this.sex=sex;
	}
	
	public String toString() {
		return sno+"  "+sname+"  "+sage+"  "+sex;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSage() {
		return sage;
	}
	public void setSage(String sage) {
		this.sage = sage;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
