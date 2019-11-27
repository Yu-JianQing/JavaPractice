package State模式;

public class ConcreteStateX extends State {
    private static ConcreteStateX cStateX = new ConcreteStateX("ConcreteStateX");

    private ConcreteStateX(String name) {
        super(name);
    }

    public static ConcreteStateX getInstance() {
        return cStateX;
    }

    @Override
    public void opr1() {
        System.out.println("ConcreteStateX opr1");
    }

    @Override
    public void opr2() {
        System.out.println("ConcreteStateX opr2");
    }

    @Override
    public void opr3() {
        System.out.println("ConcreteStateX opr3");
    }
}
