package JiuFu_4;

import java.io.FileOutputStream;

public class Main {
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		
		Content content1=Retriever.retriever("http://www.baidu.com/");
		Content content2=Retriever.retriever("http://naotu.baidu.com/");
		Content content3=Retriever.retriever("https://map.baidu.com/");
		
		saveToFile("baidu.html", content1);
		saveToFile("naotu.html", content2);
		saveToFile("ditu.html", content3);
		
		long end=System.currentTimeMillis();
		System.out.println("time="+(end-start));
	}
	
	public static void saveToFile(String fileName,Content content){
		byte [] bytes=content.getBytes();
		System.out.println(Thread.currentThread().getName()+" save to "+fileName);
		
		try {
			FileOutputStream out=new FileOutputStream(fileName);
			for (int i = 0; i < bytes.length; i++) 
				out.write(bytes[i]);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
