package Command模式;

public class Invoker {
    private ConcreteCommandX commandX;

    public Invoker(ConcreteCommandX commandX) {
        this.commandX = commandX;
    }

    public void invoke(){
        commandX.execute();
    }

    public void undo() throws Exception{
        commandX.undo();
    }
}
