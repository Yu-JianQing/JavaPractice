package Observer模式;

public class ConcreteSubject extends Subject {
    @Override
    public void use() {
        System.out.println("ConcreteSubject use");
        observersWork();
    }
}
