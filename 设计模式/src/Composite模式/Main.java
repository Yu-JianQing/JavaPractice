package Compositeģʽ;

public class Main {
	public static void main(String[] args) {
		try {
			
			Directory rootDirectory=new Directory("root");
			Directory binDirectory=new Directory("bin");
			File xFile=new File("x",520);
			File yFile=new File("y", 13);
			File zFile=new File("z", 14);
			
			rootDirectory.add(binDirectory);
			rootDirectory.add(xFile);
			binDirectory.add(yFile);
			binDirectory.add(zFile);
			
			rootDirectory.printList();
			
			System.out.println("-----------------");
			
			System.out.println(xFile.getPath());
			System.out.println(yFile.getPath());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
