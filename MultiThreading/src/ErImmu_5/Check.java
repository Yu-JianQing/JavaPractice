package ErImmu_5;

public class Check extends Thread{
	private final MutablePerson mPerson;
	
	public Check(MutablePerson mPerson){
		this.mPerson=mPerson;
	}
	
	public void run(){
		while(true){
			ImmutablePerson imPerson=new ImmutablePerson(mPerson);
			if(imPerson.getName().charAt(0)!=imPerson.getAddress().charAt(0))
				System.out.println(currentThread().getName()+"broke"+imPerson);
		}
	}
}
