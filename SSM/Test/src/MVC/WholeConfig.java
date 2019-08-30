package MVC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import MMA.UserDao;

@Configuration
@ComponentScan(basePackages={"Test","Service","MVC"})
public class WholeConfig {
	
	@Bean
	public ApplicationContext context(){
		ApplicationContext context=new ClassPathXmlApplicationContext("Mapper/ApplicationConfig.xml");
		return context;
	}
	
	@Bean
	public UserDao userDao(){
		UserDao userDao=(UserDao) context().getBean("userMapper");
		return userDao;
	}
	
}
