package YiSTE;

public class Main_2 {
	public static void main(String[] args) {
		BoundedResource_2 resource=new BoundedResource_2(3);
		
		for(int i=0;i<10;i++){
			new User_2(resource).start();
		}
		
	}
}
