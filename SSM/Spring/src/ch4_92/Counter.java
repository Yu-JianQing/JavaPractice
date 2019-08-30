package ch4_92;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Counter {
	private Map<Integer, Integer> map=new HashMap<Integer, Integer>();
	
	public Map<Integer, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Integer> map) {
		this.map = map;
	}

	public int getCount(int num){
		return map.containsKey(num)?map.get(num):0;
	}
	
	//通知方法
	public void count(int num){
		map.put(num, getCount(num));
		System.out.println(getCount(num));
	}
	//通知方法
	public void count2(int num){
		System.out.println(getCount(num));
	}
	
	public void count3(ProceedingJoinPoint jp,int num) throws Throwable{
		System.out.println("sss"+num);
		jp.proceed();
	}
	
}
