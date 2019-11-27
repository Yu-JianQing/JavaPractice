package FactoryMethod模式;

public class ConcreteProduct extends Product{
    private String owner;

    private int id;

    public ConcreteProduct(String owner,int id) {
        this.owner=owner;
        this.id=id;
    }

    @Override
    public void use() {
        System.out.println(owner+"  "+id);
    }
}
