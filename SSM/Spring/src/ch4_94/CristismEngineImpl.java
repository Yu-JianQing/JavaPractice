package ch4_94;

import java.util.Random;

public class CristismEngineImpl implements CriticismEngine{
	private String[] pool;
	
	public CristismEngineImpl(){}
	
	public void setPool(String[] pool) {
		this.pool = pool;
	}
	
	public String getCriticism(){
		int i=new Random().nextInt(3);
		return pool[i];
	}
	
}
