package Iterator模式;

public class Main {
    public static void main(String[] args) {
        Element el1 = new Element(1, "tom");
        Element el2 = new Element(2, "jerry");

        Aggregate ag = new ConcreteAggregate();
        ag.add(el1);
        ag.add(el2);

        Iterator iterator = ag.iterator();
        while (iterator.hasNext()) {
            Element e = (Element) iterator.next();
            System.out.println(e);
        }
    }
}
