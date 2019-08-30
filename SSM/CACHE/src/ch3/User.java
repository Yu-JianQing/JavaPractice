package ch3;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String id;
	
	public User(){}
	
	public User(String id){
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}
	
}
