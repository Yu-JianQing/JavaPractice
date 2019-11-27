package Prototype模式;

public abstract class AbstractPrototype implements Prototype {
    protected int id;

    public abstract void use();

    @Override
    public Prototype createPropertyByClone() {
        Prototype p = null;
        try {
            p = (Prototype) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
