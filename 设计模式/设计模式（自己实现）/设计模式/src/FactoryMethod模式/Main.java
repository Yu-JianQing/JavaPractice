package FactoryMethod模式;

public class Main {
    public static void main(String[] args) {
        Creator creator=new ConcreteCreator();
        Product p=creator.createProduct("tom",1);
        p.use();
    }
}
