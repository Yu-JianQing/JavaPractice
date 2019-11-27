package Visitor模式;

public abstract class Visitor {
    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    public abstract void visit(ConcreteElement element);

    public abstract void visit(ConcreteElementX element);

}
