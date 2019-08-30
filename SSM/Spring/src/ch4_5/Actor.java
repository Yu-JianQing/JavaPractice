package ch4_5;

import org.springframework.stereotype.Component;

@Component
public class Actor implements Performance{

	public void perform() {
		System.out.println("actor performing");
	}

}
