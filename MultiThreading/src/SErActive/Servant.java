package SErActive;

public class Servant implements ActiveObject{
	public Result<String> makeString(int count, char fillchar) {
		char [] cs=new char[count];
		for (int i = 0; i < count; i++) 
			cs[i]=fillchar;
		String str=new String(cs);
		return new RealResult<String>(str);
	}

	public void displayString(String string) {
		try {
			System.out.println("dispalying :"+string);
			Thread.sleep(50);
		} catch (InterruptedException e) {}
	}

	public Result<String> add(String x, String y) {
		String resultValue=String.valueOf(Integer.parseInt(x)+Integer.parseInt(y));
		RealResult<String> realResult=new RealResult<String>(resultValue);
		return realResult;
	}

}
