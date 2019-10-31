package Builderģʽ;

public class Dirctor {
	private Builder builder;
	
	public Dirctor(Builder builder){
		this.builder=builder;
	}
	
	public void construct(){
		builder.makeTitle("tiltle");
		builder.makeContent("content");
		builder.makeNote("note");
		builder.close();
	}
	
}
