package ShiTPT_4;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyTask implements Runnable{
	private static final int phase=5;
	private final CyclicBarrier phaseBarrier;
	private final CountDownLatch doneLatch;
	private final int context;
	private static final Random RANDOM=new Random(1314159);
	
	public MyTask(CyclicBarrier phaseBarrier,CountDownLatch doneLatch,	int context){
		this.phaseBarrier=phaseBarrier;
		this.doneLatch=doneLatch;
		this.context=context;
	}
	
	protected void doPhase(int phase){
		String name=Thread.currentThread().getName();
		System.out.println(name+" : my task begin :context ="+context+"   phase= "+phase);
		try {
			Thread.sleep(RANDOM.nextInt(3000));
		} catch (InterruptedException e) {
		}finally{
			System.out.println(name+" : my task end :context ="+context+"   phase= "+phase);
		}
	}
	
	public void run() {
		
		try {
			for (int i = 0; i < phase; i++) {
				doPhase(i);
				phaseBarrier.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}finally{
			doneLatch.countDown();
		}
		
	}

}
