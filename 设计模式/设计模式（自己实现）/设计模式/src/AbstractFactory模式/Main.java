package AbstractFactory模式;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory("AbstractFactory.ConcreteFactory");
        AbstractItemX itemX = factory.createItemX(1, "x", "tom");
        AbstractItemY itemY = factory.createItemY(2, "y", "jerry");
        AbstractProduct product = factory.createProduct(1, "product");

        itemX.use();
        itemX.printx();
        itemY.use();
        itemY.printy();

        product.add(itemX);
        product.add(itemY);
        product.puse();

    }
}
