package Proxy模式;

public class RealSubject implements Subject {
    public RealSubject(){
        System.out.println("real subject init----timing---");
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
        try {
            System.out.println("opr3 ing");
            Thread.sleep(3000);
            System.out.println("opr3 done");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
