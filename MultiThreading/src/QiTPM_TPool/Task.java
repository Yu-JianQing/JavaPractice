package QiTPM_TPool;

public class Task implements Runnable{
	private int taskNum;
	
	public Task(int num){
		this.taskNum=num;
	}
	
	public void run() {
		System.out.println("����ִ��task"+taskNum);
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task"+taskNum+"ִ�����");
	}

}
