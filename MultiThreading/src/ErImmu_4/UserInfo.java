package ErImmu_4;

public class UserInfo {
	private final StringBuffer info;
	public UserInfo(String name,String address){
		this.info=new StringBuffer("info:"+name+"   " +address);
	}
	
	public StringBuffer getInfo(){
		return this.info;
	}
	
	public String toString(){
		return this.info+"string ";
	}
	
}
