package ch4_94;

public class CriticAspect {
	
	private CriticismEngine criticismEngine;

	public CriticAspect(){}
	
	public void setCriticismEngine(CriticismEngine criticismEngine) {
		this.criticismEngine = criticismEngine;
	}
	
	public void before(){
		System.out.println("44444");
	}
	
	public void after(){
		System.out.println("5555");
	}

}
