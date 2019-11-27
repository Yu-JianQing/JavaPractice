package Observer模式;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> list=new ArrayList<>();

    public abstract void use();

    public void add(Observer observer){
        list.add(observer);
    }

    public void observersWork(){
        for(Observer observer:list)
            observer.work();
    }
}
