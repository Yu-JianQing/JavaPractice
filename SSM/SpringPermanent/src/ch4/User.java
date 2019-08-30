package ch4;

import org.springframework.stereotype.Component;

@Component
public class User {
	int uno;
	String uname;
	String pwd;
	int tel;
	String address;
	
	public User(){}
	
	public User(int uno, String uname, String pwd, int tel, String address) {
		super();
		this.uno = uno;
		this.uname = uname;
		this.pwd = pwd;
		this.tel = tel;
		this.address = address;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [uno=" + uno + ", uname=" + uname + ", pwd=" + pwd
				+ ", tel=" + tel + ", address=" + address + "]";
	}
	
}
