package aboutUtil;

import java.util.Random;

public class aboutMathAndRandom {
	public static void main(String[] args) {
		double i=Math.random();	//0-1
		
		double j=Math.floor(15.3);//����x����С��
		
		double k=Math.round(56.4);//��������
		double k2=Math.round(-56.4);
		
		Random random=new Random();
		boolean m=random.nextBoolean();
		
		System.out.println(i+"  "+j+"  "+k+"  "+k2+"  "+m);
		
	}
}