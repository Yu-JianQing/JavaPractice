package ch3;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImp implements TestService{

	@Override
	public void service() {
		System.out.println("testing.......");
	}

}
