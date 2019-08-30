package Test;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Order {
	private int rno;
	private int status;
	private List<Detail> details;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<Detail> getDetails() {
		return details;
	}
	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Order [rno=" + rno + ", status=" + status + ", details="
				+ details + "]";
	}
}
