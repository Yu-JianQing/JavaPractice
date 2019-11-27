package Command模式;

public abstract class Command {
    public abstract void execute();
    public abstract void undo() throws Exception;
}
