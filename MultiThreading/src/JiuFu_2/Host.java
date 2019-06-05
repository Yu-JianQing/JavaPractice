package JiuFu_2;

import java.util.concurrent.Callable;

public class Host {
	public Data request(int count,char c){
		System.out.println("request "+count+" "+c+" begin");
		
		FutureData future=new FutureData(
				new Callable<RealData>() {
					@Override
					public RealData call() throws Exception {
						return new RealData(count, c);
					}
				}
		);
		new Thread(future).start();
		
		System.out.println("request "+count+" "+c+" end");
		return future;
	}
}
