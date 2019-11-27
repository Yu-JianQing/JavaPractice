package Visitor模式;

public class ConcreteVisitor extends Visitor {
    public ConcreteVisitor(String name) {
        super(name);
    }

    @Override
    public void visit(ConcreteElement element) {
        element.add();
        element.remove();
    }

    @Override
    public void visit(ConcreteElementX element) {
        element.remove();
        element.add();
    }
}
