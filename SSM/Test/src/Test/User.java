package Test;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;

@Component
public class User {
	private int uno;
	
	@NotBlank(message="{name}")
	private String uname;
	
	@Length(min=3,message="{pwd}")
	private String pwd;
	
	@NumberFormat(style=Style.NUMBER)
	private int tel;
	
	@NotBlank(message="{address}")
	private String address;
	
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
