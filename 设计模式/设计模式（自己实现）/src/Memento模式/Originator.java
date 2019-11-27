package Memento模式;

public class Originator {
    private int id;

    private String name;

    private String state;

    public Originator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento save(){
        return new Memento(state);
    }

    public void recover(Memento memento){
        this.state=memento.getState();
    }

    public void changeState(){
        this.state="state "+Math.random();
    }
}
