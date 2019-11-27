package Proxyģʽ�Ľ�;

public class PrinterProxy implements Printable{
	private String name;
	private Printable realPrinter;
	private String realPrinterClassName;
	
	public PrinterProxy(){}
	
	public PrinterProxy(String name,String realPrinterClassName){
		this.name=name;
		this.realPrinterClassName=realPrinterClassName;
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
			if(realPrinter==null){
				realPrinter=(Printable) Class.forName(realPrinterClassName).newInstance();
				realPrinter.setPrinterName(name);//��ΪClass.forName���õ����޲εĹ��췽��������Ҫsetname
			}
			realPrinter.print(str);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
