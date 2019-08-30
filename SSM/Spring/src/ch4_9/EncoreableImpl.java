package ch4_9;

import org.springframework.stereotype.Component;

@Component
public class EncoreableImpl implements Encoreable{

	@Override
	public void Encore() {
		System.out.println(666666666);
	}

}
