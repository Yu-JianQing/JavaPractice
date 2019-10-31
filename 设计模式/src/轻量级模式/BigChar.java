package 轻量级模式;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BigChar {
	private char c;
	private String str;
	
	public BigChar(char c){
		this.c=c;
		File file=new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试\\big"+this.c+".txt");
		try {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			StringBuffer buffer=new StringBuffer();
			String s;
			while((s=reader.readLine())!=null){
				buffer.append(s+"\n");
			}
			reader.close();
			str=buffer.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("???");
		}
	}
	
	public String getStr(){
		return str;
	}
}
