package Compositeģʽ;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
	private String name;
	private List<Entry> list=new ArrayList<Entry>();
	
	public Directory(String name){
		this.name=name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getSize() {
		int size=0;
		for(Entry entry:list)
			size=size+entry.getSize();
		return size;
	}

	@Override
	protected void printList(String root) {
		System.out.println(root+"/"+this);
		for(Entry entry:list)
			entry.printList(root+"/"+name);
	}
	
	public void add(Entry entry) throws FileNotAllowAdd{
		list.add(entry);
		entry.parent=this;
	}

}
