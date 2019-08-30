package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tom")
public class Tom implements People{
	private Animal animal;
	
	@Autowired
	public Tom(Animal animal){
		this.animal=animal;
	}
	
	@Autowired
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void speak() {
		animal.speak();
	}

}
