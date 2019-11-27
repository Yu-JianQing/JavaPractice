package Adapter模式2;

public class Main {
    public static void main(String[] args) {
        Target target=new Adapter("jerry");
        target.tprint('x');
    }
}
