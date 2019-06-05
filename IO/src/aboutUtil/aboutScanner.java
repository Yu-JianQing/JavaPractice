package aboutUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class aboutScanner {//Scanner：扫描器
	public static void main(String[] args) throws IOException {
		String str="hello tom ,hi i am jerry.   CAT AND MOUSE  111589112";
		
		String regex="[^0123456789.]+";//scanner不仅用于解析字符串，还可解析流、文件等//注意与stringtokenizer的区别P194
		Scanner scanner=new Scanner(str);
		
		while(scanner.hasNext()){
			String string=scanner.next();
			System.out.println(string);
		}
		
		/**********************************************/
		
		File file=new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试\\Object.txt");
		Scanner scanner2=new Scanner(file);
		
		scanner2.useDelimiter("[^0123456789.]+");
		
		while(scanner.hasNext()){
			String string=scanner.next();
			System.out.println(string);
		}
		
	}
}
