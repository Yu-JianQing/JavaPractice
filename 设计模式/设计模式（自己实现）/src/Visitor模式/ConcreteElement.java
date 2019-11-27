package Visitor模式;

public class ConcreteElement extends Element {
    public ConcreteElement(String name) {
        super(name);
    }

    @Override
    public void add() {
        System.out.println("queue add");
    }

    @Override
    public void remove() {
        System.out.println("queue remove");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
