package Prototype模式;

public class Main {
    public static void main(String[] args) {
        AbstractPrototype p1=new ConcretePrototype("tom",1);
        Manager manager=new Manager();
        manager.register(1, p1);
        AbstractPrototype p2= (AbstractPrototype) manager.createPrototype(1);
        p2.use();
    }
}
