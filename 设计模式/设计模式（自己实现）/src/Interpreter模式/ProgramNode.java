package Interpreter模式;

public class ProgramNode extends Node{
	private Node listNode;

	@Override
	public void parse(Context context) throws ParseException {
		if(context.getCurToken()!=null)
			context.skipToken("program");
		listNode=new CommandListNode();
		listNode.parse(context);
	}
	
	public String toString(){
		return "[program"+listNode+"]";
	}

}
