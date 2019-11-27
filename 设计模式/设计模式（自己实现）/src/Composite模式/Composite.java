package Composite模式;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private int cid;
    private List<Component> list;

    public Composite(String name, int cid) {
        super(name);
        this.cid = cid;
        list = new ArrayList<>();
    }

    @Override
    public void use() {
        System.out.println("composite");
        for (Component component : list)
            System.out.println(component);
    }

    public void special() throws Exception {
        System.out.println("special");
    }

    public void add(Component component) throws Exception {
        list.add(component);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "cid=" + cid +
                ", list=" + list +
                '}';
    }
}
