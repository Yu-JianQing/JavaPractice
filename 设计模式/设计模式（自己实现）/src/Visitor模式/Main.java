package Visitor模式;

public class Main {
    public static void main(String[] args) {
        Element e1=new ConcreteElement("tom");
        Element e2=new ConcreteElementX("jerry");

        Visitor visitor=new ConcreteVisitor("visitor");

        e1.accept(visitor);
        e2.accept(visitor);
    }
}
