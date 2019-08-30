package num5;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Jerry {

	private String name;
	private Map<Integer, String> hobbies;
	private Book book;
	
	public Jerry(){}
	
	public Jerry(String name, Map<Integer, String> hobbies, Book book) {
		super();
		this.name = name;
		this.hobbies = hobbies;
		this.book = book;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<Integer, String> getHobbies() {
		return hobbies;
	}
	
	public void setHobbies(Map<Integer, String> hobbies) {
		this.hobbies = hobbies;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
