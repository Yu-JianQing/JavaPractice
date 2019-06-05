package JiuFu_3;

public class AsynContentImp implements Content{
	private SynContentImp realContent=null;
	private boolean ready=false;
	
	public synchronized void set(SynContentImp realContent){
		if(ready)
			return ;
		this.realContent=realContent;
		this.ready=true;
		notifyAll();
	}
	
	public synchronized byte[] getBytes() {
		try {
			while(!ready)
				wait();
		} catch (InterruptedException e) {}
		
		return realContent.getBytes();
	}

}
