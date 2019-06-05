package YiSTE_2;

//一个线程想要获取多个不同的资源可以通过资源的获取顺序和获取每个资源的锁实现互斥

public class CopyOfMain {
	public static void main(String[] args) {
		CopyOfTool spoon=new CopyOfTool("spoon");
		CopyOfTool fork=new CopyOfTool("fork");
		new CopyOfEaterThread("Tom", spoon, fork).start();
		//像哲学家问题中的奇数号哲学家拿左边的筷子，偶数号哲学家拿右边的筷子，
		//但只有左右筷子都拿到才能吃饭
		new CopyOfEaterThread("Jerry", spoon, fork).start();
	}
}
