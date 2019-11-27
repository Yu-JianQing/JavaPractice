package Interpreter模式;

public class RepeatCommandNode extends Node{
	private int number;
	private Node listNode;

	@Override
	public void parse(Context context) throws ParseException {
		context.skipToken("repeat");
		number=context.curNumber();
		context.nextToken();
		listNode=new CommandListNode();
		listNode.parse(context);
	}
	
	public String toString(){
		return "[repeat "+number+" "+listNode+"]";
	}

}