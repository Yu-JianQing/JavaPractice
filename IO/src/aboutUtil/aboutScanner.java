package aboutUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class aboutScanner {//Scanner��ɨ����
	public static void main(String[] args) throws IOException {
		String str="hello tom ,hi i am jerry.   CAT AND MOUSE  111589112";
		
		String regex="[^0123456789.]+";//scanner�������ڽ����ַ��������ɽ��������ļ���//ע����stringtokenizer������P194
		Scanner scanner=new Scanner(str);
		
		while(scanner.hasNext()){
			String string=scanner.next();
			System.out.println(string);
		}
		
		/**********************************************/
		
		File file=new File("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����\\Object.txt");
		Scanner scanner2=new Scanner(file);
		
		scanner2.useDelimiter("[^0123456789.]+");
		
		while(scanner.hasNext()){
			String string=scanner.next();
			System.out.println(string);
		}
		
	}
}
