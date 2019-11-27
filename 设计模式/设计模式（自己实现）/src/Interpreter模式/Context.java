package Interpreter模式;

import java.util.StringTokenizer;

public class Context {
	private StringTokenizer tokenizer;
	private String curToken;
	
	public Context(String text){
		tokenizer=new StringTokenizer(text);
		nextToken();
	}
	
	public String nextToken(){
		if(tokenizer.hasMoreTokens())
			curToken=tokenizer.nextToken();
		else
			curToken=null;
		return curToken;
	}
	
	public String getCurToken(){
		return curToken;
	}
	
	public void skipToken(String token) throws ParseException{
		if(!token.equals(token))
			throw new ParseException("the "+token+" is not found");
		nextToken();
	}
	
	public int curNumber() throws ParseException{
		int number=0;
		try {
			number=Integer.parseInt(curToken);
		} catch (Exception e) {
			throw new ParseException(e.getMessage());
		}
		return number;
	}

}
