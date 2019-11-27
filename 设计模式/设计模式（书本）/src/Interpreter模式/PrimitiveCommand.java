package Interpreterģʽ;

public class PrimitiveCommand extends Node{
	private String name;

	@Override
	public void parse(Context context) throws ParseException {
		name=context.getCurToken();
		context.skipToken(name);
		if(!name.equals("go")&&!name.equals("left")&&!name.equals("right"))
			throw new ParseException(name+" is undefined");
	}
	
	public String toString(){
		return name;
	}

}