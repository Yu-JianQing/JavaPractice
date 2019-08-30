package ch2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DogConfig.class)//引入Java配置文件中的bean
public class PeopleConfig {
	@Bean(name="tom")//通过引入使得两个bean结合起来
	public Tom tom(Animal animal){
		return new Tom(animal);
	}
	
	
	
}
