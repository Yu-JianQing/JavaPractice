package AbstractFactory模式;

public class ConcreteItemX extends AbstractItemX {
    private String name;

    public ConcreteItemX(int id, String typeX, String name) {
        this.id = id;
        this.typeX = typeX;
        this.name = name;
    }

    @Override
    public void printx() {
        System.out.println(name);
    }

    @Override
    public void use() {
        System.out.println(id + " " + typeX + " " + name);
    }
}
