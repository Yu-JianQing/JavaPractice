package ch7;

public class Tom implements Student{

	@Override
	public void solveQuestion(CallBack callBack) {
		System.out.println("Tom solving");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Tom solved");
		callBack.getAnswer("tom");
	}

}
