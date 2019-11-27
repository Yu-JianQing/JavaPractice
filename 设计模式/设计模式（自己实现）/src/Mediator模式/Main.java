package Mediator模式;

public class Main {
    public static void main(String[] args) {
        ConcreteColleague colleague = new ConcreteColleague("tom");
        ConcreteColleagueX colleagueX = new ConcreteColleagueX("jerry");

        Mediator mediator = new ConcreteMediator("mediator");
        colleague.setMediator(mediator);
        colleagueX.setMediator(mediator);

        mediator.giveOrder();
    }
}
