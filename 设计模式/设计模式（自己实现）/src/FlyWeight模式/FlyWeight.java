package FlyWeight模式;

public class FlyWeight {
    private int id;

    private String name;

    public FlyWeight(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FlyWeight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
