package JiuFu;

public class FutureData implements Data{
	private RealData realData=null;
	private boolean ready=false;
	
	public synchronized void setRealData(RealData realData){
		if(ready)
			return ;
		this.realData=realData;
		this.ready=true;
		notifyAll();
	}
	
	public synchronized  String getContent() {
		while(!ready){
			try {
				wait();//因为有wait所以此方法外加syn
			} catch (InterruptedException e) {}
		}
		return realData.getContent();
	}

}
