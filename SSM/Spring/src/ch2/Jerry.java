package ch2;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Jerry implements People{
	private String name;
	private String sex;
	private List<String> foods;
	
	public Jerry(String name,String sex,List<String> foods){
		this.name=name;
		this.sex=sex;
		this.foods=foods;
	}
	
	public void speak() {
		System.out.println(name+":"+sex);
		for(String s:foods)
			System.out.println("food:"+s);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getFoods() {
		return foods;
	}

	public void setFoods(List<String> foods) {
		this.foods = foods;
	}
	
	

}
