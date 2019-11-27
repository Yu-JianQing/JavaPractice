package Interpreterģʽ;

public class CommandNode extends Node{
	private Node node;

	@Override
	public void parse(Context context) throws ParseException {
		if(context.getCurToken().equals("repeat")){
			node=new RepeatCommandNode();
			node.parse(context);
		}else{
			node=new PrimitiveCommand();
			node.parse(context);
		}
	}
	
	public String toString(){
		return node.toString();
	}
	
}
