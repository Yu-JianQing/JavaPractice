package Proxyģʽ;

public class Main {
	public static void main(String[] args) {
		Printable p=new PrinterProxy("alice");
		System.out.println("current name is "+p.getPrinterName());
		p.setPrinterName("bob");
		System.out.println("current name is "+p.getPrinterName());
		p.print("hello world");
	}
}
