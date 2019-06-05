package JiuFu_4;

import java.util.concurrent.Callable;

public class Retriever {
	public static Content retriever(String urlstr){
		final AsynContentImp fuContent=new AsynContentImp(new Callable<SynContentImp>() {
			public SynContentImp call() throws Exception {
				SynContentImp realContent=new SynContentImp(urlstr);
				return realContent;
			}
		});
		
		new Thread(fuContent).start();
		
		return fuContent;
	}
}
