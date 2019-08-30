package ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class People {
	Dessert dessert;
	
	@Autowired
	@Qualifier("cake")////利用qualifier设置自动装配的bean的限制。autowired和qualifier的配合
			//此处是用了默认的bean的id限制
	public void setDessert(Dessert dessert){
		this.dessert=dessert;
	}
	
	@Autowired
	@Qualifier("cook")
	public void setDessert2(Dessert dessert){
		this.dessert=dessert;
	}
	
	@Autowired
	public void setDessert3(Dessert dessert){
		this.dessert=dessert;
	}
}
