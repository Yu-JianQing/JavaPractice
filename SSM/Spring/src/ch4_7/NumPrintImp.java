package ch4_7;

import org.springframework.stereotype.Component;

@Component
public class NumPrintImp implements NumPrint{

	@Override
	public void print(int num) {
		System.out.println(num);
	}

}
