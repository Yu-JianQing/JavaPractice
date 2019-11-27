package Prototype模式;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<Integer, AbstractPrototype> map = new HashMap<>();

    public void register(int id, AbstractPrototype p) {
        map.put(id, p);
    }

    public Prototype createPrototype(int id) {
        AbstractPrototype p = map.get(id);
        return p.createPropertyByClone();
    }
}
