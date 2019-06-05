package SErActive_3;

public class ActiveObjectFactory {
	public static Proxy CreateActiveObjects(){
		ActivationQueue queue=new ActivationQueue();
		Servant servant=new Servant();
		SchedulerThread scheduler=new SchedulerThread(queue, "scheduler");
		Proxy proxy=new Proxy(scheduler, servant);
		scheduler.start();
		return proxy;
	}
}
