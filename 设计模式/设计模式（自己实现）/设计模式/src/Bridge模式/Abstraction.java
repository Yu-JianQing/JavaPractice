package Bridge模式;

public abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void before(){
        implementor.before();
    }
    public void mid(){
        implementor.mid();
    }
    public void after(){
        implementor.after();
    }

    public abstract void addMethod();
}
