package aboutUtil;

import java.util.Calendar;
import java.util.Date;

public class aboutDateAndCalendar {		//calden£∫»’¿˙
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		System.out.println(System.currentTimeMillis());
		
		Calendar calendar=Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		
		calendar.set(2008, 8, 8, 8, 8, 8);
		System.out.println(calendar);
		
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		System.out.println(year+"  "+month);
		
	}
}
