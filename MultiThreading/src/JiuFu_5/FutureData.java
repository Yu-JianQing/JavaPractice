package JiuFu_5;

public class FutureData implements Data{
	private RealData realData=null;
	private boolean ready=false;
	private Exception exception=null;
	
	public synchronized void setRealData(RealData realData){
		if(ready)
			return ;
		this.realData=realData;
		this.ready=true;
		notifyAll();
	}
	
	public synchronized void setException(Throwable throwable){
		if(ready)
			return ;
		this.exception=new Exception(throwable);
		this.ready=true;//此处等于真是为了getContent时可以跳出while循环
		notifyAll();
	}
	
	public synchronized  String getContent() throws Exception{
		while(!ready){
			try {
				wait();//因为有wait所以此方法外加syn
			} catch (InterruptedException e) {}
		}
		if(exception!=null)
			throw exception;
		return realData.getContent();
	}

}
