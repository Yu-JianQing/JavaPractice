package SErActive_3;

public class Servant extends ActiveObject{

	public Result<String> search(String word){
		System.out.println("search "+ word);
		for (int i = 0; i < 30; i++) {
			System.out.print("*");
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {}
		}
		System.out.println("found *");
		String url="http://"+word+".html";
		return new RealResult(url);
	}
}
