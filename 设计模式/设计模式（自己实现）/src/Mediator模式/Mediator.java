package Mediator模式;

public abstract class Mediator {
    private String name;

    public Mediator(String name) {
        this.name = name;
    }

    public abstract void giveOrder();

    public abstract void addColleague(Colleague colleague);
}
