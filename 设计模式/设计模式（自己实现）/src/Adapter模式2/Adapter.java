package Adapter模式2;

public class Adapter extends Target{
    Adaptee adaptee;

    public Adapter(String name) {
        adaptee=new Adaptee(name);
    }

    @Override
    public void tprint(char x) {
        adaptee.print(x);
    }
}
