package Strategy模式;

public class Main {
    public static void main(String[] args) {
        int num[] = {2, 3, 7, 8, 4, 1, 9};
//        Context context=new Context(new ConcreteStrategy());
        Context context = new Context(new ConcreteStrategyX());
        context.print(num);
    }
}
