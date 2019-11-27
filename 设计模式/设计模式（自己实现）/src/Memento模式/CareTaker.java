package Memento模式;

public class CareTaker {
    Memento memento;
    Originator originator;

    public CareTaker(Originator originator) {
        this.originator = originator;
        memento=originator.save();
    }

    public void manage(){
        if(Math.random()>0.2){
            System.out.println("cur state :" + originator.getState());
            memento=originator.save();
            originator.changeState();
            System.out.println("after state :" + originator.getState());
        }else {
            originator.recover(memento);
            System.out.println("recoving ***");
        }
    }
}
