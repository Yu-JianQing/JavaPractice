package aboutUtil;

import java.util.Calendar;
import java.util.Date;

public class aboutformat {
	public static void main(String[] args) {
		//���ڸ�ʽ��
		Date date=new Date();
		
		String str1=String.format("%tY��%tm��%td��", date,date,date);
		System.out.println(str1);
		
		String str2=String.format("%tF", date);
		System.out.println(str2);
		
		Calendar calendar=Calendar.getInstance();
		
		String s3=String.format("%tY-%tm-%td", calendar,calendar,calendar);
		System.out.println(s3);
		
		calendar.set(Calendar.YEAR, 2005);
		String s4=String.format("%tF", calendar);
		System.out.println(s4);
		
		//���ָ�ʽ��
		String s1=String.format("%d����%2fԪ", 1,0.1);
		System.out.println(s1);
		
		String s2=String.format("100��ʮ���ƣ�%d,�˽��ƣ�%o,ʮ�����ƣ�%x", 100,100,100);
		System.out.println(s2);
	}
}