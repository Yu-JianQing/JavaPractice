package Decorator模式;

public class Main {
    public static void main(String[] args) {
        Component cp=new ConcreteComponent("tom",1);
        cp.use();

        Component decorator=new ConcreteDecorator("jerry",cp,2);
        decorator.use();

        System.out.println("-------------");

        Component decorator2=new ConcreteDecorator("jerry",new ConcreteDecorator("jack",cp,3),2);
        decorator2.use();
    }
}
