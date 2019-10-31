package Visitorģʽ;

import java.util.Iterator;

public abstract class Entry implements Element{
	protected Entry parent;
	
	public abstract String getName();
	public abstract int getSize();
	
	protected abstract void printList(String root);
	
	public void printList(){
		printList("");
	}
	
	public void add(Entry entry) throws FileNotAllowAdd{
		throw new FileNotAllowAdd("file is not allow add");
	}
	
	public String getPath(){
		StringBuffer buffer=new StringBuffer();
		Entry entry=this;
		do {
			buffer.insert(0, "/"+entry.getName());
			entry=entry.parent;
		} while (entry!=null);
		
		return buffer.toString();
	}
	
	@Override
	public String toString(){
		return getName()+"   "+getSize();
	}

	public Iterator<Entry> iterator() throws Exception{
		throw new Exception("file is noot allow iterator");
	}
	
}
