package num5;

import java.util.List;

public class User {
	private int uid;
	private String uname;
	private String usex;
	private List<Orders> orders;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", usex=" + usex
				+ ", orders=" + orders + "]";
	}
}
