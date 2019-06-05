package SiBalking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {
	private final String filename;
	private String content;
	private boolean changed;
	
	public Data(String filename,String content){
		this.filename=filename;
		this.content=content;
		this.changed=true;
	}
	
	public synchronized void change(String newContent){
		this.content=newContent;
		changed=true;
	}
	
	private void doSave() throws IOException{
		System.out.println(Thread.currentThread().getName()+"   dosave   "+content);
		Writer writer=new FileWriter(filename);
		writer.write(content);
		writer.close();
	}
	
	public synchronized void save() throws IOException,InterruptedException{
		if(!changed){
			System.out.println("not changed");//调试使用
			return ;
		}
		Thread.sleep(100);	//调试使用
		doSave();
//		Thread.sleep(100);	
		changed=false;
	}
	
}
