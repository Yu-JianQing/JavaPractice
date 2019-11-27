package Visitor模式;

public class ConcreteElementX extends Element {
    public ConcreteElementX(String name) {
        super(name);
    }

    @Override
    public void add() {
        System.out.println("stack add");
    }

    @Override
    public void remove() {
        System.out.println("stack remove");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
