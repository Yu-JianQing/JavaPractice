package Visitor模式;

public abstract class Element {
    private String name;

    public Element(String name) {
        this.name = name;
    }

    public abstract void add();

    public abstract void remove();

    public abstract void accept(Visitor visitor);
}
