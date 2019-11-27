package ³éÏó¹¤³§;

public abstract class Factory {
	public abstract Screw createScrew(String ItemName,String type);
	
	public abstract SmallBox createSmallBox(String ItemName);
	
	public abstract PackBox createPackBox(String maker,String time);
	
	public static Factory getFactory(String factoryClassName){
		Factory factory=null;
		try {
			factory=(Factory) Class.forName(factoryClassName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return factory;
	}
	
}
