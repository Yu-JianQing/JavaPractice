package aboutUtil;

import java.util.StringTokenizer;

public class aboutStringTokenizer {//tokenizer:标记,分析器
	public static void main(String[] args) {
		String str="hello tom ,hi i am jerry.   CAT AND MOUSE  111589112";
		
//		StringTokenizer tokenizer=new StringTokenizer(str);
		StringTokenizer tokenizer=new StringTokenizer(str, "act");//act区分大小写
		
		int count=0;
		while(tokenizer.hasMoreTokens()){
			
			String string=tokenizer.nextToken();
			
			count=tokenizer.countTokens();
			
			System.out.println(string+"还有："+count+"个");
		}
	}
}
