package ch3_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cart2 implements Cart{
	String name;
	int age;
	
	public Cart2(@Value("${name}") String name, @Value("${age}") int age){
		//利用占位符来注入属性值
		this.name=name;
		this.age=age;
	}
	
}
