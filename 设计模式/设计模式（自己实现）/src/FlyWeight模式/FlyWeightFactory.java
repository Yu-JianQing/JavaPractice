package FlyWeight模式;

import java.util.HashMap;

public class FlyWeightFactory {
    private static FlyWeightFactory factory=new FlyWeightFactory();
    private HashMap<Integer,FlyWeight> map=new HashMap<>();

    private FlyWeightFactory(){}

    public static FlyWeightFactory getInstance(){
        return factory;
    }

    public FlyWeight getFlyWeight(int id,String name){
        FlyWeight flyWeight=map.get(id);
        if(flyWeight==null){
            flyWeight=new FlyWeight(id,name);
            map.put(id,flyWeight);
        }
        return flyWeight;
    }
}
