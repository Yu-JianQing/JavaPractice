package AbstractFactory模式;

public class ConcreteFactory extends AbstractFactory {
    @Override
    public AbstractItemX createItemX(int id, String typeX, String name) {
        return new ConcreteItemX(id, typeX, name);
    }

    @Override
    public AbstractItemY createItemY(int id, String typeY, String name) {
        return new ConcreteItemY(id, typeY, name);
    }

    @Override
    public AbstractProduct createProduct(int pid, String pname) {
        return new ConcreteProduct(pid, pname);
    }
}
