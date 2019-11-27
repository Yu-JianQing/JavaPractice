package Adapter模式;

public class Main {
    public static void main(String[] args) {
        Target t=new Adapter("tom");
        t.tprint('x');
    }
}
