package ch3;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Test3 {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config2.class);
		
		RedisTemplate<Object,Object> redisTemplate=(RedisTemplate<Object,Object>) context.getBean("redisTemplate");
		
		for(int i=1;i<6;i++)
			redisTemplate.opsForSet().add("set", i);
		
		redisTemplate.opsForSet().remove("ser", 3);
		
		int x=(int) redisTemplate.opsForSet().randomMember("set");
		System.out.println(x);
		
		Object object=redisTemplate.opsForSet().pop("set");
		System.out.println(object);
		
		Long size=redisTemplate.opsForSet().size("set");
		System.out.println(size);
		
		
		for(int i=3;i<8;i++)
			redisTemplate.opsForSet().add("set2", i);
		
		Set<Object> diff=(Set<Object>) redisTemplate.opsForSet().difference("set", "set2");
		System.out.println("diff:"+diff);
		
		Set<Object> union=(Set<Object>) redisTemplate.opsForSet().union("set", "set2");
		System.out.println("union"+union);
		
		Set<Object> isect=(Set<Object>) redisTemplate.opsForSet().intersect("set", "set2");
		System.out.println("isect"+isect);
		
	}
}
