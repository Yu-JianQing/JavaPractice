package WuPC_4;

public class Host {
	private static void doHeavyJob(){
		System.out.println("Heavy Job Begin");
		long start=System.currentTimeMillis();
		while(start+2000>System.currentTimeMillis()){
			//do job
		}
		System.out.println("Heavy Job End");
	}
	
	public static void execute(int count) throws InterruptedException{
		for(int i=0;i<count;i++){
			if(Thread.interrupted())
				throw new InterruptedException();
			doHeavyJob();
		}
	}
}
