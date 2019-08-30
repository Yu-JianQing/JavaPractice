package ch4_6;

import org.springframework.stereotype.Component;

@Component
public class Calculator implements Calculat{

	public int add(int i, int j) {
		return i+j;
	}

}
