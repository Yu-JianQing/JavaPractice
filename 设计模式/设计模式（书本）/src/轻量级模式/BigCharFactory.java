package 轻量级模式;

import java.util.HashMap;

public class BigCharFactory {
	private static BigCharFactory factory=new BigCharFactory();
	
	private HashMap<String, BigChar> map=new HashMap<String, BigChar>();
	
	private BigCharFactory(){}
	
	public static BigCharFactory getInstance(){
		return factory;
	}
	
	public synchronized BigChar getBigChar(char c){
		BigChar bigChar=map.get(""+c);
		if(bigChar==null){
			bigChar=new BigChar(c);
			map.put(""+c, bigChar);
		}
		return bigChar;
	}
}
