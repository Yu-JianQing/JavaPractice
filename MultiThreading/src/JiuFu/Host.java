package JiuFu;

public class Host {
	public Data request(int count,char c){
		System.out.println("request "+count+" "+c+" begin");
		
		final FutureData future=new FutureData();
		
		new Thread(){
			public void run(){
				RealData realData=new RealData(count, c);
				future.setRealData(realData);
			}
		}.start();
		
		System.out.println("request "+count+" "+c+" end");
		return future;
	}
}
