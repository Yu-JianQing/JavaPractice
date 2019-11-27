package ChainOfResponsibility;

public class ConcreteHandlerY extends Handler{

    public ConcreteHandlerY(String name) {
        super(name);
    }

    @Override
    public boolean resolve() {
        System.out.println("resolve success");
        return true;
    }

    @Override
    public void success() {
        System.out.println("concreteHandlery success");
    }

    @Override
    public void faile() {
        System.out.println("concreteHandlery failed");
    }
}
