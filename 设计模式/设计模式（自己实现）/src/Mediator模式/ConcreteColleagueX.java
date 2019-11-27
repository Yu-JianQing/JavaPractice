package Mediator模式;

public class ConcreteColleagueX extends Colleague {
    private Mediator mediator;

    public ConcreteColleagueX(String name) {
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
            System.out.println("concrete colleaguex is not allowed");
    }

    @Override
    public void doThings() {
        System.out.println("concrete colleaguex do some things");
    }
}
