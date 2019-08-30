package ch1;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	@Cacheable("cache1")
	public String eat(String thing){
		return thing;
	}
	
	@CachePut("cache2")
	public int age(int age){
		return age;
	}
	
	@CachePut(value="cache3",key="#result.hash")
	public String sex(){
		return "男";
	}
	
	@CachePut(value="cache4",key="#root.methodName")
	public String name(){
		return "tom";
	}
	
	@Cacheable(value="cache5",key="root.methodName",
			unless="#result.hash.contains('10')")
	public double walk(){
		return Math.random();
	}
	
//	@CacheEvict("cache2")
//	public void retire(int age){
//		System.out.println("lalala");
//	}
	
}
