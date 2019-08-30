package ch3;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int uno;
	String uname;
	
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
	@Override
	public String toString() {
		return "Person [uno=" + uno + ", uname=" + uname + "]";
	}
}
