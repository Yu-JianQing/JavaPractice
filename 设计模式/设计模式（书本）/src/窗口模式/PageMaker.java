package ����ģʽ;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class PageMaker {
	private PageMaker(){}
	
	public static void makePage(String mailaddr,String fileName){
		try {
			Properties properties=DataBase.getProperties("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����\\maildata.property");
			String userName=properties.getProperty(mailaddr);
			HtmlWriter writer=new HtmlWriter(new FileWriter(new File(fileName)));
			
			writer.title("this is title");
			writer.makeMsg("welcome");
			writer.makeMsg("hello");
			writer.mailto(mailaddr, userName);
			writer.close();
			System.out.println(fileName+"   "+mailaddr+"   "+userName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
