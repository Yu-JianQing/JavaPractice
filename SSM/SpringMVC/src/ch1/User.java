package ch1;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	@NotNull
	@Size(min=1,max=10)
	private String name;
	
	@NotNull
	@Max(10000)
	private String pass;
	
	@NotNull
	@Pattern(regexp="[0-9]+")
	private String repass;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
}
