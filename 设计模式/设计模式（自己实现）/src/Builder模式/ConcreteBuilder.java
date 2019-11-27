package Builder模式;

public class ConcreteBuilder extends Builder{
    @Override
    public void buildHead() {
        System.out.println("buildHead");
    }

    @Override
    public void buildBody() {
        System.out.println("buildBody");
    }

    @Override
    public void buildFoot() {
        System.out.println("buildFoot");
    }
}
