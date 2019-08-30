package ch4;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String name;
	private String pwd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwdS(String pwd) {
		this.pwd = pwd;
	}
}
