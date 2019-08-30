package ch1;

public class Tom implements Student{

	@Override
	public void resolveQuestion(Callback callback) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		
		callback.getAnswer(3);
	}

}
