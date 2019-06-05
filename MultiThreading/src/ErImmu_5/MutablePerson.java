package ErImmu_5;

public class MutablePerson {
	private String name;
	private String address;
	
	public MutablePerson(String name,String address){
		this.name=name;
		this.address=address;
	}
	
	public MutablePerson(ImmutablePerson person){
		this.name=person.getName();
		this.address=person.getAddress();
	}

	public synchronized void setPerson(String newName,String newAddress){
		this.name=newName;
		this.address=newAddress;
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}
