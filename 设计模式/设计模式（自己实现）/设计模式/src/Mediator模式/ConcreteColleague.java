package Mediator模式;

public class ConcreteColleague extends Colleague {
    private Mediator mediator;

    public ConcreteColleague(String name) {
        super(name);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.addColleague(this);
    }

    @Override
    public void allow(boolean order) {
        if (order)
            doThings();
        else
            System.out.println("concrete colleague is not allowed");
    }

    @Override
    public void doThings() {
        System.out.println("concrete colleague do some things");
    }
}
