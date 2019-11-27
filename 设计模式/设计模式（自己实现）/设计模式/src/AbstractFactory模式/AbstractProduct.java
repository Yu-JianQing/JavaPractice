package AbstractFactory模式;

public abstract class AbstractProduct {
    protected int pid;

    public abstract void puse();

    public abstract void add(SuperItem item);
}
