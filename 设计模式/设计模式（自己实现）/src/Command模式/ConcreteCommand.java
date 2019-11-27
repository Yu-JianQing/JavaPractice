package Command模式;

public class ConcreteCommand extends Command {
    private int id;
    private Receiver reciver;

    public ConcreteCommand(int id, Receiver reciver) {
        this.id = id;
        this.reciver=reciver;
    }

    @Override
    public void execute() {
        System.out.println("command " + id + " execute");
        reciver.behavior(id);
    }

    @Override
    public void undo() throws Exception{
        System.out.println("one command is not allowed undo");
    }
}
