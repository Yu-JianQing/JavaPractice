package JiuFu_5;

public class Host {
	public Data request(int count,char c){
		System.out.println("request "+count+" "+c+" begin");
		
		final FutureData future=new FutureData();
		new Thread(){
			public void run(){
				try {
					RealData realData=new RealData(count, c);
					future.setRealData(realData);
				} catch (Exception e) {
					future.setException(e);
				}
			}
		}.start();
		
		System.out.println("request "+count+" "+c+" end");
		return future;
	}
}
