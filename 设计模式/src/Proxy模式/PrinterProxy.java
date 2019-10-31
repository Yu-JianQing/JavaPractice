package Proxyģʽ;

public class PrinterProxy implements Printable{
	private String name;
	private Printer realPrinter;
	
	public PrinterProxy(){}
	
	public PrinterProxy(String name){
		this.name=name;
	}

	@Override
	public void setPrinterName(String name) {
		if(realPrinter!=null)
			realPrinter.setPrinterName(name);
		this.name=name;
	}

	@Override
	public String getPrinterName() {
		return name;
	}
	
	@Override
	public void print(String str) {
		try {
			if(realPrinter==null)
				realPrinter=new Printer(name);
			realPrinter.print(str);
		} catch (Exception e) {}
	}

}
