package TemplateMethod模式;

public class ConcreteClass extends AbstractClass{
    @Override
    public void step1() {
        System.out.println("step1");
    }

    @Override
    public void step2() {
        System.out.println("step2");
    }

    @Override
    public void step3() {
        System.out.println("step3");
    }
}
