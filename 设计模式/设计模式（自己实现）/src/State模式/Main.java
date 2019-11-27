package State模式;

public class Main {
    public static void main(String[] args) {
        State state = ConcreteState.getInstance();
        State statex = ConcreteStateX.getInstance();

        Context context = new Context(state);

        context.myOpr();
        context.myOpr2();

        context.changeState(statex);

        context.myOpr();
        context.myOpr2();
    }
}
