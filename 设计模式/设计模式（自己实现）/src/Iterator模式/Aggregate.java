package Iterator模式;

public abstract class Aggregate {
    public abstract Iterator iterator();

    public abstract void add(Element element);

    public abstract int length();
}
