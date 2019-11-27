package Decorator模式;

public abstract class Decorator extends Component {
    protected Component component;

    public Decorator(String name, Component component) {
        super(name);
        this.component = component;
    }

    public abstract void print();
}
