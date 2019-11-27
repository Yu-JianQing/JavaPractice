package Bridge模式;

public class Main {
    public static void main(String[] args) {
        Abstraction abs=new RefinedAbstraction(new ConcreteImplementor(),"tom");

        abs.addMethod();
        abs.before();
        abs.mid();
        abs.after();
    }
}
