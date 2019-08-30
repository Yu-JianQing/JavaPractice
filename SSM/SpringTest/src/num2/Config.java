package num2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	public Book book(){
		return new Book();
	}
	
	@Bean
	public Tom tom(Book book){
		return new Tom(book);
	}
	
	@Bean
	public Tom tom1(){
		Book book=new Book();
		return new Tom(book);
	}
	
	@Bean
	public Tom tom2(){
		Book book=new Book();
		Tom tom=new Tom();
		tom.setBook(book);
		return tom;
	}
	
}
