package State模式;

public abstract class State {
    private String name;

    public State(String name) {
        this.name = name;
    }

    public abstract void opr1();

    public abstract void opr2();

    public abstract void opr3();
}
