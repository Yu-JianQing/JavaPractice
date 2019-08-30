package ch2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
public class DogConfig {
//configuration用于定义配置类，一般用于创建bean对象
//componentScan注解是启动Spring的组件（bean）扫描。自动装配法。

//以下是Java配置装配方式
	@Bean(name="animal")
	public Animal animal(){
		int choice=(int)Math.random()*3;
		switch(choice){
			case 0:return new Dog();
			case 1:return new Cat();
			case 2:return new Mouse();
		}
		return null;
	}
	
	
	//以下3个bean选其一注入，否则会发生错误
	@Bean
	public Tom tom(){
		return new Tom(animal());//此处传入的参数对应着前面所声明的bean的方法名()
	}
	
	@Bean//注入bean的另一种方式，使用引用其他bean的方式
	public Tom tom2(Animal animal){
		return new Tom(animal);
	}
	
	@Bean//set方法注入
	public Tom tom3(Animal animal){
		Tom tom=new Tom(animal);
		tom.setAnimal(animal);
		return tom;
	}
	
}
