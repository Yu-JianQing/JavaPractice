package AbstractFactory模式;

public abstract class AbstractFactory {

    public abstract AbstractItemX createItemX(int id, String typeX, String name);

    public abstract AbstractItemY createItemY(int id, String typeY, String name);

    public abstract AbstractProduct createProduct(int pid, String pname);

    public static AbstractFactory getFactory(String name) {
        AbstractFactory factory = null;
        try {
            factory = (AbstractFactory) Class.forName(name).newInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
        return factory;
    }
}
