package State模式;

public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void myOpr() {
        state.opr1();
        state.opr3();
    }

    public void myOpr2() {
        state.opr2();
    }
}
