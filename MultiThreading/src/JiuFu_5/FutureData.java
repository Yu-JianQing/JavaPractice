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
		this.ready=true;//�˴���������Ϊ��getContentʱ��������whileѭ��
		notifyAll();
	}
	
	public synchronized  String getContent() throws Exception{
		while(!ready){
			try {
				wait();//��Ϊ��wait���Դ˷������syn
			} catch (InterruptedException e) {}
		}
		if(exception!=null)
			throw exception;
		return realData.getContent();
	}

}
