package ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		RedisTemplate<String,Person> redisTemplate=(RedisTemplate) context.getBean("redisTemplate");
		
		Person person=new Person();
		person.setUno(7);
		person.setUname("tom7");
		redisTemplate.opsForValue().set("tom7", person);
		
		Person tom=(Person) redisTemplate.opsForValue().get("tom7");
		System.out.println(tom);
		
	}
}
