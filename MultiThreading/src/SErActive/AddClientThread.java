package SErActive;

public class AddClientThread extends Thread{
	private final ActiveObject activeObject;
	
	public AddClientThread(ActiveObject activeObject,String name){
		super(name);
		this.activeObject=activeObject;
	}
	
	public void run(){
		int i=1,j=1;
		while(true){
			Result<String> result=activeObject.add(String.valueOf(i), String.valueOf(j));
			System.out.println(i+" + "+j+" = "+result.getResultValue());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
			i=j;
			j=Integer.parseInt(result.getResultValue());
		}
	}
	
}