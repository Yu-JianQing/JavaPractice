package ch3_3;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private String name;
	private List<String> hobbiesList;
	private Map<String, String> addressMap;
	private Set<String> aliasSet;
	private String [] array;
	
	public User(){super();}
	
	public User(String name,List<String> hobbiesList,Map<String, String> addressMap,Set<String> aliasSet,String [] array){
		this.name=name;
		this.hobbiesList=hobbiesList;
		this.addressMap=addressMap;
		this.aliasSet=aliasSet;
		this.array=array;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getHobbiesList() {
		return hobbiesList;
	}

	public void setHobbiesList(List<String> hobbiesList) {
		this.hobbiesList = hobbiesList;
	}

	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}

	public Set<String> getAliasSet() {
		return aliasSet;
	}

	public void setAliasSet(Set<String> aliasSet) {
		this.aliasSet = aliasSet;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public String toString(){
		return name+hobbiesList+addressMap+aliasSet+array;
	}
}
