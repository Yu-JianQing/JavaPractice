package Observer模式;

public class ConcreteObserver extends Observer {
    @Override
    public void work() {
        System.out.println("ConcreteObserver work");
    }
}
