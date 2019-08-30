package ch4_7;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Counter {
	private Map<Integer, Integer> map=new HashMap<Integer, Integer>();
	
	@Pointcut("execution(** ch4_7.NumPrint.print(int))"+"&& args(num)")
	public void numprint(int num){}
	
	public int getCount(int num){
		return map.containsKey(num)?map.get(num):0;
	}
	
	@Before("numprint(num)")
	public void count(int num){
		map.put(num, getCount(num));
		System.out.println(getCount(num));
	}
	
	@After("numprint(num)")
	public void count2(int num){
		System.out.println(getCount(num));
	}
	
}
