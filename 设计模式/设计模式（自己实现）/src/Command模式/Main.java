package Command模式;

public class Main {
    public static void main(String[] args) throws Exception{
        Receiver receiver = new Receiver("receiver");
        ConcreteCommand command = new ConcreteCommand(0, receiver);
        Command command1 = new ConcreteCommand(1, receiver);
        Command command2 = new ConcreteCommand(2, receiver);
        ConcreteCommandX commandx=new ConcreteCommandX();

        commandx.add(command);
        commandx.add(command1);
        commandx.add(command2);
        Invoker invoker=new Invoker(commandx);

        invoker.invoke();
        invoker.undo();
        invoker.invoke();
    }
}
