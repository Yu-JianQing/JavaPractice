package ch5;

public class Person {
	private int id;
	private String name;
	private int age;
	private IdCard card;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public IdCard getCard() {
		return card;
	}
	public void setCard(IdCard card) {
		this.card = card;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", card=" + card + "]";
	}
	
}
