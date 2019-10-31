package Proxy模式改进;

public class Main {
	public static void main(String[] args) {
		Printable p=new PrinterProxy("alice","Proxy模式改进.Printer");
		System.out.println("current name is "+p.getPrinterName());
		p.setPrinterName("bob");
		System.out.println("current name is "+p.getPrinterName());
		p.print("hello world");
	}
}
