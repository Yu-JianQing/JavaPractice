package FactoryMethod模式;

import java.util.ArrayList;

public class ConcreteCreator extends Creator{
    private ArrayList<Product> list=new ArrayList<>();

    @Override
    public Product produceProduct(String owner, int id) {
        return new ConcreteProduct(owner,id);
    }

    @Override
    public void register(Product p) {
        list.add(p);
    }
}
