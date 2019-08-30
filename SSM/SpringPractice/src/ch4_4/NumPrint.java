package ch4_4;

import org.springframework.stereotype.Component;

@Component
public class NumPrint implements Print{

	@Override
	public void print() {
		System.out.println(11111);
	}

}
