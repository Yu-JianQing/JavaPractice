package ChainOfResponsibility;

public class ConcreteHandlerX extends Handler{

    public ConcreteHandlerX(String name) {
        super(name);
    }

    @Override
    public boolean resolve() {
        System.out.println("concreteHandlerx can't resolve");
        return false;
    }

    @Override
    public void success() {
        System.out.println("concreteHandlerx success");
    }

    @Override
    public void faile() {
        System.out.println("concreteHandlerx failed");
    }
}
