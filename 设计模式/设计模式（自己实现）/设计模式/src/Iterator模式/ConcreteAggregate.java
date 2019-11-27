package Iterator模式;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate extends Aggregate {
    private List<Element> list = new ArrayList<>();

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public void add(Element element) {
        list.add(element);
    }

    @Override
    public int length() {
        return list.size();
    }

    public Element getElement(int index) {
        return list.get(index);
    }
}
