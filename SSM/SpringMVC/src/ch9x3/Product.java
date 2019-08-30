package ch9x3;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Product {
	@NotBlank(message="{input name}")
	private String name;
	
	@NotEmpty(message="{input des}")
	private String des;
	
	@Range(min=0,max=50,message="{price btween 0-50}")
	private double price;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past(message="{the date must be after the current time}")
	private Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
