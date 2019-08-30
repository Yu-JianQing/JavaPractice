package numx2;

import org.springframework.stereotype.Component;

@Component
public class PersonEat implements Eat{

	@Override
	public void eat() {
		System.out.println("eating");
	}

}
