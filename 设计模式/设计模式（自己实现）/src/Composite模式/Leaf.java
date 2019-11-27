package Composite模式;

public class Leaf extends Component {
    private int lid;

    public Leaf(String name, int lid) {
        super(name);
        this.lid = lid;
    }

    @Override
    public void use() {
        System.out.println("leaf");
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "lid=" + lid +
                '}';
    }
}
