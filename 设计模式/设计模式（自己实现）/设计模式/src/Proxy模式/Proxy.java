package Proxy模式;

public class Proxy implements Subject {
    private RealSubject realSubject;
    private String realSubjectClassName;

    public Proxy(String realSubjectClassName) {
        this.realSubjectClassName = realSubjectClassName;
    }

    @Override
    public void opr1() {
        System.out.println("opr1 done ");
    }

    @Override
    public void opr2() {
        System.out.println("opr2 done ");
    }

    @Override
    public void opr3() throws Exception{
        if(realSubject==null)
            realSubject=(RealSubject) Class.forName(realSubjectClassName).newInstance();
        realSubject.opr3();
    }
}
