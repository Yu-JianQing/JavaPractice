package ch4_92;

import org.springframework.stereotype.Component;

@Component
public class NumPrintImp implements NumPrint{

	public NumPrintImp(int i){
		System.out.println("i"+i);
	}
	
	@Override
	public void print(int num) {
		System.out.println(num);
	}

}
