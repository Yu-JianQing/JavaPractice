package ErImmu;

public class PrintPersonThread extends Thread{
	private Person person;
	
	public PrintPersonThread(Person person){
		this.person=person;
	}
	
	public void run(){
		while(true){
			Thread thread=Thread.currentThread();
			System.out.println(thread.getName()+"   "+person.toString());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
