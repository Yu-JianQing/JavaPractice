package JiuFu_3;

public class Retriever {
	public static Content retriever(String urlstr){
		final AsynContentImp fuContent=new AsynContentImp();
		new Thread(){
			public void run(){
				SynContentImp realContent=new SynContentImp(urlstr);
				fuContent.set(realContent);
			}
		}.start();
		
		return fuContent;
	}
}
