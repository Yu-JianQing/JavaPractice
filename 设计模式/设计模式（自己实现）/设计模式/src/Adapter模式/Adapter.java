package Adapter模式;

public class Adapter extends Adaptee implements Target{
    public Adapter(String name) {
        super(name);
    }

    @Override
    public void tprint(char x) {
        print(x);
    }
}
