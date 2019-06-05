package SanGS_3;

public class TalkThread extends Thread{
	private final RequestQueue input;
	private final RequestQueue output;
	
	public TalkThread(RequestQueue input,RequestQueue output,String name){
		super(name);
		this.input=input;
		this.output=output;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+"***begin");
		for(int i=0;i<20;i++){
			Request request1=input.getRequest();
			System.out.println(Thread.currentThread().getName()+"ÊÕµ½"+request1);
			Request request2=new Request(request1.getName()+"!");
			output.putRequest(request2);
			System.out.println(Thread.currentThread().getName()+"·¢ËÍ"+request2);
		}
		System.out.println(Thread.currentThread().getName()+"***end");
	}
}
