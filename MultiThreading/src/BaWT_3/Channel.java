package BaWT_3;

public class Channel {
	public void putRequest(Request request){
		new Thread(){
			public void run(){
				request.execute();
			}
		}.start();
	}
}	