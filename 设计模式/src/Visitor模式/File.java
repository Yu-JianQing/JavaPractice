package Visitorģʽ;

public class File extends Entry{
	private String name;
	private int size;
	
	public File(String name,int size){
		this.name=name;
		this.size=size;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	protected void printList(String root) {
		System.out.println(root+"/"+this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
