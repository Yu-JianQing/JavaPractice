package ch4_91;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class Audience {
	
	public void BeforePerform(){
		System.out.println("before start");
	}
	
	public void Sit(){
		System.out.println("sit");
	}
	
	public void AfterPerform(){
		System.out.println("pa pa pa ");
	}
	
	public void PerformError(){
		System.out.println("perform error");
	}
	
}
