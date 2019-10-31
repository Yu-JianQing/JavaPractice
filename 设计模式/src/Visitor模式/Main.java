package Visitorģʽ;

public class Main {
	public static void main(String[] args) {
		try {
			Directory rootDirectory=new Directory("root");
			Directory binDirectory=new Directory("bin");
			File xFile=new File("x.txt",520);
			File yFile=new File("y.txt", 13);
			File zFile=new File("z.html", 14);
			
			rootDirectory.add(binDirectory);
			rootDirectory.add(xFile);
			binDirectory.add(yFile);
			binDirectory.add(zFile);
			
			rootDirectory.printList();
			
			System.out.println("-----------------");
			
			rootDirectory.accept(new ListVisitor());
			
			System.out.println("-----------------");
			
			rootDirectory.accept(new FileFindVisitor());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
