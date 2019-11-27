package Iterator模式;

public class ConcreteIterator implements Iterator {
    private int index = 0;
    private ConcreteAggregate cg;

    public ConcreteIterator(ConcreteAggregate cg) {
        this.cg = cg;
    }

    @Override
    public boolean hasNext() {
        if (index < cg.length())
            return true;
        return false;
    }

    @Override
    public Object next() {
        return cg.getElement(index++);
    }
}
