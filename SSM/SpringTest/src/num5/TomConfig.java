package num5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
public class TomConfig {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Tom tom(){
		Book book=new Book();
		Tom tom=new Tom();
		tom.setBook(book);
		return tom;
	}
	
}
