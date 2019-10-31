package Proxyģʽ;

public class Printer implements Printable{
	private String name;
	
	public Printer() throws InterruptedException {
		System.out.println("new printer");
		Thread.sleep(2000);
	}
	
	public Printer(String name) throws InterruptedException{
		this.name=name;
		System.out.println("new printer...");
		Thread.sleep(2000);
	}

	@Override
	public void setPrinterName(String name) {
		this.name=name;
	}

	@Override
	public String getPrinterName() {
		return name;
	}

	@Override
	public void print(String str) {
		System.out.println("--------\n"+name);
		System.out.println(str);
	}

}
