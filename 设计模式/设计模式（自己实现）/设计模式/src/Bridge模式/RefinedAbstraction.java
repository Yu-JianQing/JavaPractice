package Bridge模式;

public class RefinedAbstraction extends Abstraction {
    private String name;

    public RefinedAbstraction(Implementor implementor,String name) {
        super(implementor);
        this.name=name;
    }

    @Override
    public void addMethod() {
        System.out.println(name);
    }
}
