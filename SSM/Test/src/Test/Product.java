package Test;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private int pno;
	private String pname;
	private String des;
	private double price;
	private int repertory;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRepertory() {
		return repertory;
	}
	public void setRepertory(int repertory) {
		this.repertory = repertory;
	}
	@Override
	public String toString() {
		return "Product [pno=" + pno + ", pname=" + pname + ", des=" + des
				+ ", price=" + price + ", repertory=" + repertory + "]";
	}
}
