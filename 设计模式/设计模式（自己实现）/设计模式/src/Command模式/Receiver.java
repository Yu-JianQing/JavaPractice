package Command模式;

public class Receiver {
    private String name;

    public Receiver(String name) {
        this.name = name;
    }

    public void behavior(int id){
        System.out.println("behavior " + id);
    }

}
