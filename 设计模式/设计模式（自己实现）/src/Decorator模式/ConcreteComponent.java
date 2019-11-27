package Decorator模式;

public class ConcreteComponent extends Component {
    private int id;

    public ConcreteComponent(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public void use() {
        System.out.println("ConcreteComponent use");
    }
}
