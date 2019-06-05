package ShiTPT_7;

public class Service {
	private static GracefulThread thread;
	
	public synchronized static void service(){//加上syn的目的是考虑到多台电脑都访问这个gui程序
		if(thread!=null&&thread.isAlive())
			return ;
		thread=new ServiceThread();
		thread.start();
	}
	
	public synchronized static void cancel(){
		thread.shutdownRequest();
	}
}
