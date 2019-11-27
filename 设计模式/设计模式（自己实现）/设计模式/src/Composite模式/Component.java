package Composite模式;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void use();

    public void special() throws Exception {
        throw new Exception("only composite use (special)");
    }

    public void add(Component component) throws Exception {
        throw new Exception("only composite use (add)");
    }
}
