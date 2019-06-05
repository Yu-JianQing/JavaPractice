package QiTPM_TPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		ThreadPoolExecutor executor=new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		for (int i = 0; i < 15; i++) {
			Task task=new Task(i);
			executor.execute(task);
			System.out.println("�̳߳����̵߳���Ŀ��"+executor.getPoolSize()+",�����еȴ�ִ�е�������Ŀ��"
					+executor.getQueue().size()+",��ִ�����������Ŀ��"+executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}
