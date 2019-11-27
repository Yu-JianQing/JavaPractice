package State模式;

public class ConcreteState extends State {
    private static ConcreteState cState = new ConcreteState("ConcreteState");

    private ConcreteState(String name) {
        super(name);
    }

    public static ConcreteState getInstance() {
        return cState;
    }

    @Override
    public void opr1() {
        System.out.println("ConcreteState opr1");
    }

    @Override
    public void opr2() {
        System.out.println("ConcreteState opr2");
    }

    @Override
    public void opr3() {
        System.out.println("ConcreteState opr3");
    }
}
