package SErActive_3;

public class Proxy extends ActiveObject{
	private final SchedulerThread scheduler;
	private final Servant servant;
	
	public Proxy(SchedulerThread scheduler,Servant servant){
		this.scheduler=scheduler;
		this.servant=servant;
	}
	
	public Result<String> search(String word) {
		FutureResult future=new FutureResult();
		scheduler.invoke(new SearchRequest(servant, future, word));
		return future;
	}

}
