package ShiTPT_7;

public class Service {
	private static GracefulThread thread;
	
	public synchronized static void service(){//����syn��Ŀ���ǿ��ǵ���̨���Զ��������gui����
		if(thread!=null&&thread.isAlive())
			return ;
		thread=new ServiceThread();
		thread.start();
	}
	
	public synchronized static void cancel(){
		thread.shutdownRequest();
	}
}
