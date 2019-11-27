package FactoryMethod模式;

public abstract class Creator {
    public abstract Product produceProduct(String owner, int id);

    public abstract void register(Product p);

    public final Product createProduct(String owner, int id) {
        Product p = produceProduct(owner, id);
        register(p);
        return p;
    }
}
