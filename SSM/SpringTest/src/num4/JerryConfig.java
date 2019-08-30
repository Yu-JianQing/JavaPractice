package num4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JerryConfig {

	@Bean
	public Jerry jerry(){
		Book book=new Book();
		Jerry jerry=new Jerry();
		jerry.setName("jerry");
		jerry.setBook(book);
		jerry.setHobbies(null);
		return jerry;
	}
	
}
