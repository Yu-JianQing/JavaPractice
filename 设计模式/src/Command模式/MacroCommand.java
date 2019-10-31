package Commandģʽ;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command{
	private Stack<Command> commands=new Stack<Command>();

	public void add(Command command){
		if(command!=this)
			commands.push(command);
	}
	
	public void undo(){
		if(!commands.isEmpty())
			commands.pop();
	}
	
	public void clear(){
		commands.clear();
	}
	
	@Override
	public void execute() {
		Iterator<Command> iterator=commands.iterator();
		while(iterator.hasNext()){
			Command command=iterator.next();
			command.execute();
		}
	}

}
