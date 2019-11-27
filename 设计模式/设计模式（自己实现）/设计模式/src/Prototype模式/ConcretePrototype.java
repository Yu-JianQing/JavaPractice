package Prototype模式;

public class ConcretePrototype extends AbstractPrototype {
    private String name;

    public ConcretePrototype(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void use() {
        System.out.println(name + "  " + id);
    }
}
