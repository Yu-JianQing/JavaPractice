package Proxy模式;

public class Main {
    public static void main(String[] args) throws Exception {
        Subject subject = new Proxy("Proxy.RealSubject");
        subject.opr1();
        subject.opr2();
        subject.opr3();
    }
}
