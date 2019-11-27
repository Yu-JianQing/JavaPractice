package Memento模式;

public class Main {
    public static void main(String[] args) {
        Originator originator=new Originator(1,"tom");
        originator.setState("0");

        CareTaker taker=new CareTaker(originator);

        for (int i = 1; i < 10; i++) {
            taker.manage();
        }
    }
}
