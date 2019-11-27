package Builder模式;

public class Director {
    Builder builder;

    public Director(Builder builder){
        this.builder=builder;
    }

    public void construct(){
        builder.buildHead();
        builder.buildBody();
        builder.buildFoot();
    }
}
