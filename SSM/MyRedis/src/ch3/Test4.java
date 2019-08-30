package ch3;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class Test4 {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config2.class);
		
		RedisTemplate<Object,Object> redisTemplate=(RedisTemplate<Object,Object>) context.getBean("redisTemplate");
		
		for(int i=0;i<5;i++)
			redisTemplate.opsForList().rightPush("list", i);
		
		BoundListOperations<Object, Object> list=redisTemplate.boundListOps("list");
		
		Object object=list.rightPop();
		System.out.println(object);
		list.rightPush(8);
		list.rightPush(9);
		System.out.println(list.index(4));
		
		
	}
}
