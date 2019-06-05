package aboutUtil;

import java.util.Calendar;
import java.util.Date;

public class aboutformat {
	public static void main(String[] args) {
		//日期格式化
		Date date=new Date();
		
		String str1=String.format("%tY年%tm月%td日", date,date,date);
		System.out.println(str1);
		
		String str2=String.format("%tF", date);
		System.out.println(str2);
		
		Calendar calendar=Calendar.getInstance();
		
		String s3=String.format("%tY-%tm-%td", calendar,calendar,calendar);
		System.out.println(s3);
		
		calendar.set(Calendar.YEAR, 2005);
		String s4=String.format("%tF", calendar);
		System.out.println(s4);
		
		//数字格式化
		String s1=String.format("%d角是%2f元", 1,0.1);
		System.out.println(s1);
		
		String s2=String.format("100的十进制：%d,八进制：%o,十六进制：%x", 100,100,100);
		System.out.println(s2);
	}
}
