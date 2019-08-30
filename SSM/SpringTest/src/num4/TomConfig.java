package num4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomConfig {
	
	@Bean
	public Book book(){
		return new Book();
	}
	
	@Bean
	public Tom tom(Book book){
		return new Tom(book);
	}
	
}
