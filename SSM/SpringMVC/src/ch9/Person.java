package ch9;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	private String pwd;
	private int age;
	private String sex;
	
	public Person(){}
	
	public Person(String name, String pwd, int age, String sex) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.sex = sex;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", pwd=" + pwd + ", age=" + age
				+ ", sex=" + sex + "]";
	}
}
