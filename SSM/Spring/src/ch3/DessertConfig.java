package ch3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan//开启自动装配
public class DessertConfig {

	@Bean//不开启自动装配，手动装配时的首选设置
	@Primary//利用primary设置手动装配的bean的首选项。bean和primary的配合
	public Dessert iceCream(){
		return new IceCream();
	}
	
	
	
}
