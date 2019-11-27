package Adapter模式;

public class Adaptee {
    private String name;

    public Adaptee(String name) {
        this.name = name;
    }

    public void print(char c) {
        System.out.printf(c + name + c);
    }
}
