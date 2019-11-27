package AbstractFactory模式;

public class ConcreteItemY extends AbstractItemY {
    private String name;

    public ConcreteItemY(int id, String typeY, String name) {
        this.id = id;
        this.typeY = typeY;
        this.name = name;
    }

    @Override
    public void printy() {
        System.out.println(name);
    }

    @Override
    public void use() {
        System.out.println(id + " " + typeY + " " + name);
    }
}
