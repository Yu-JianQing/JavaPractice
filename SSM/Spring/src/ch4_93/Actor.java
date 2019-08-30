package ch4_93;

import org.springframework.stereotype.Component;

@Component
public class Actor implements Performance{

	public void perform() {
		System.out.println("actor performing");
	}

}
