package Visitorģʽ;

import java.util.Iterator;

public class ListVisitor extends Visitor{
	private String curDir="";

	@Override
	public void visit(File file) {
		System.out.println(curDir+"/"+file);
	}

	@Override
	public void visit(Directory directory) {
		try {
			System.out.println(curDir+"/"+directory);
			String saveDir=curDir;
			curDir=curDir+"/"+directory.getName();
			
			Iterator<Entry> iterator=directory.iterator();
			while(iterator.hasNext()){
				Entry entry=iterator.next();
				entry.accept(this);
			}
			
			curDir=saveDir;
		} catch (Exception e) {
			System.out.println("xxxxxxxx");
		}
	}

}
