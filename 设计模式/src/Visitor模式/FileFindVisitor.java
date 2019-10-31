package Visitorģʽ;

import java.util.Iterator;

public class FileFindVisitor extends Visitor{
	
	@Override
	public void visit(File file) {
		if(file.getName().endsWith(".txt"))
			System.out.println(file);
	}

	@Override
	public void visit(Directory directory) {
		try {
			Iterator<Entry> iterator=directory.iterator();
			while(iterator.hasNext()){
				Entry entry=iterator.next();
				entry.accept(this);
			}
		} catch (Exception e) {}
	}

}
