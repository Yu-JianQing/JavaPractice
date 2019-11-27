package AbstractFactory模式;

import java.util.ArrayList;
import java.util.List;

public class ConcreteProduct extends AbstractProduct {
    private String pname;
    private List<SuperItem> list = new ArrayList<SuperItem>();

    public ConcreteProduct(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    @Override
    public void puse() {
        System.out.println(pid + "  " + pname + " " + list);
    }

    @Override
    public void add(SuperItem item) {
        list.add(item);
    }
}
