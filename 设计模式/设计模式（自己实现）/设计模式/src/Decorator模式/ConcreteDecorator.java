package Decorator模式;

public class ConcreteDecorator extends Decorator{
    private int cid;

    public ConcreteDecorator(String name, Component component,int cid) {
        super(name,component);
        this.cid = cid;
    }

    @Override
    public void print() {
        System.out.println("lalala");
    }

    @Override
    public void use() {
        System.out.println("decorator");
        component.use();
    }
}
