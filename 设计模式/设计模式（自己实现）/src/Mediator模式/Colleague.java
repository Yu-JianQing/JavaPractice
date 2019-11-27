package Mediator模式;

public abstract class Colleague {
    private String name;

    public Colleague(String name) {
        this.name = name;
    }

    public abstract void setMediator(Mediator mediator);

    public abstract void allow(boolean order);

    public abstract void doThings();

}
