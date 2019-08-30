package ch3;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config2.class);
		
		RedisTemplate<Object,Object> redisTemplate=(RedisTemplate<Object,Object>) context.getBean("redisTemplate");
		
		for(int i=1;i<6;i++)
			redisTemplate.opsForHash().put("map", i, i);
		
		Map<Object, Object> map=redisTemplate.opsForHash().entries("map");
		System.out.println(map);
		
		Set<Object> keys=redisTemplate.opsForHash().keys("map");
		System.out.println(keys);
		// map的key值相同，后添加的覆盖原有的,不允许有重复的key
		
		List<Object> values=redisTemplate.opsForHash().values("map");
		System.out.println(values);
		
		long size=redisTemplate.opsForHash().size("map");
		System.out.println(size);
		
		redisTemplate.opsForHash().delete("map", 3);
		
	}
}
