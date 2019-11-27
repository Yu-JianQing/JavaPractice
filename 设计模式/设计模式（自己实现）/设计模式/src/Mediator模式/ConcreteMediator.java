package Mediator模式;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator extends Mediator {
    private List<Colleague> list = new ArrayList<>();

    public ConcreteMediator(String name) {
        super(name);
    }

    @Override
    public void giveOrder() {
        Colleague colleague = list.get(0);
        Colleague colleague1 = list.get(1);
        colleague.allow(true);
        colleague1.allow(false);
    }

    @Override
    public void addColleague(Colleague colleague) {
        list.add(colleague);
    }
}
