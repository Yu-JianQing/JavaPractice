package ChainOfResponsibility;

public class ConcreteHandler extends Handler{

    public ConcreteHandler(String name) {
        super(name);
    }

    @Override
    public boolean resolve() {
        System.out.println("concreteHandler can't resolve");
        return false;
    }

    @Override
    public void success() {
        System.out.println("concreteHandler success");
    }

    @Override
    public void faile() {
        System.out.println("concreteHandler failed");
    }
}
