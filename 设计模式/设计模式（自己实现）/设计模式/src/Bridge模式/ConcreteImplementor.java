package Bridge模式;

public class ConcreteImplementor extends Implementor {
    @Override
    public void before() {
        System.out.println("before");
    }

    @Override
    public void mid() {
        System.out.println("mid");
    }

    @Override
    public void after() {
        System.out.println("after");
    }
}
