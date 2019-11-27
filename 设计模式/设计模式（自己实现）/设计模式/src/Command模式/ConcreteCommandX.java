package Command模式;

import java.util.Iterator;
import java.util.Stack;

public class ConcreteCommandX extends Command{
    private Stack<Command> stack;

    public ConcreteCommandX() {
        stack=new Stack<>();
    }

    @Override
    public void execute() {
        Iterator<Command> iterator=stack.iterator();
        while ((iterator.hasNext())){
            Command command=iterator.next();
            command.execute();
        }
    }

    public void add(Command command){
        stack.add(command);
    }

    public void remove(Command command){
        stack.remove(command);
    }

    @Override
    public void undo() throws Exception{
        Command command=stack.pop();
        System.out.println("undoing-----");
        command.execute();
        System.out.println("undone-----");
    }

    public void clear(){
        stack.clear();
    }
}
