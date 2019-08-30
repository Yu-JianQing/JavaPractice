package com.Web_2;

import java.io.Serializable;

public class Student  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String name;
	String pwd;
	String sex;
	String[] hobbies;
	String province;
	String info;
	
	public Student(){}
	public Student(String name,String pwd,String sex,String[] hobbies,String province,String info){
		this.name=name;
		this.pwd=pwd;
		this.sex=sex;
		this.hobbies=hobbies;
		this.province=province;
		this.info=info;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
