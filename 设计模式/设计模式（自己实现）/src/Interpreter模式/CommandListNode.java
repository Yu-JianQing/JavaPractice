package Interpreter模式;

import java.util.ArrayList;
import java.util.List;

public class CommandListNode extends Node{
	private Node command;
	private List<Node> list=new ArrayList<Node>();
	
	@Override
	public void parse(Context context) throws ParseException {
		while(true){
			if(context.getCurToken()==null)
				throw new ParseException("no end");
			else if(context.getCurToken().equals("end")){
				context.skipToken("end");
				break ;
			}
			else {
				command=new CommandNode();
				command.parse(context);
				list.add(command);
			}
		}
	}
	
	public String toString(){
		return list.toString();
	}

}
