package Composite模式;

public class Main {
    public static void main(String[] args) throws Exception {
        Component c1 = new Leaf("l1", 1);
        Component c2 = new Leaf("l2", 2);
        Component c3 = new Leaf("l3", 3);
        Component c4 = new Composite("c4", 4);
        Component c5 = new Leaf("l5", 5);

        Component c = new Composite("c", 9);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c4.add(c5);
        c.add(c4);

        c.special();
        c.use();
    }
}
