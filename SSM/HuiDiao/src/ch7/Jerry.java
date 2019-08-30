package ch7;

public class Jerry implements Student{

	@Override
	public void solveQuestion(CallBack callBack) {
		System.out.println("Jerry solving");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Jerry solved");
		callBack.getAnswer("jerry");
	}

}
