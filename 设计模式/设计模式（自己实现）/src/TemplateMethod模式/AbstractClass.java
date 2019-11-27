package TemplateMethod模式;

public abstract class AbstractClass {
    public abstract void step1();

    public abstract void step2();

    public abstract void step3();

    public final void toGo() {
        step1();
        step2();
        step3();
        System.out.println("finished!");
    }
}
