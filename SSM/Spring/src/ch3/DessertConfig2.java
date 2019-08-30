package ch3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan//开启自动装配
public class DessertConfig2 {
	
	@Bean//不开启自动装配，手动装配时的限制设置
	@Qualifier("cook")//利用qualifier设置手动装配的限制。bean和qualifier配合
	public Dessert cookies(){
		return new Cookies();
	}
}
