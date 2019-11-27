package Observer模式;

public class Main {
    public static void main(String[] args) {
        Subject subject=new ConcreteSubject();

        Observer observer=new ConcreteObserver();
        Observer observerx=new ConcreteObserverX();

        subject.add(observer);
        subject.add(observerx);

        subject.use();
    }
}
