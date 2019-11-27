package ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        Handler handler=new ConcreteHandler("concreteHandler");
        Handler handler2=new ConcreteHandlerX("concreteHandlerx");
        Handler handler3=new ConcreteHandlerY("concreteHandlery");

        handler.setNext(handler2).setNext(handler3);

        handler.resolve();

        System.out.println("-------------");

        handler.support();
    }
}
