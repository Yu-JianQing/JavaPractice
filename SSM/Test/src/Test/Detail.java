package Test;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Detail {
	private int dno;
	private int uno;
	private int count;
	private double sum;
	private Date time;
	private Product product;
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Detail [dno=" + dno + ", uno=" + uno + ", count=" + count
				+ ", sum=" + sum + ", time=" + time + ", product=" + product
				+ "]";
	}
	
}
