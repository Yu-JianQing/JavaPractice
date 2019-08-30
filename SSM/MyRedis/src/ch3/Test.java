package ch3;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		StringRedisTemplate redisTemplate=(StringRedisTemplate) context.getBean("redisTemplate");
		
		for(int i=0;i<5;i++)
			redisTemplate.opsForList().rightPush("mylist", i+"");
		redisTemplate.opsForList().leftPush("mylist", "x");
		
		String r1=redisTemplate.opsForList().rightPop("mylist");
		System.out.println(r1);
		String l1=redisTemplate.opsForList().leftPop("mylist");
		System.out.println(l1);
		
		List<String> list=redisTemplate.opsForList().range("mylist", 0, 2);
		System.out.println(list);
		
		redisTemplate.opsForList().remove("mylist", 1, "1");
		//可能重名，所以要指定位置和value
		
	}
}
