package Brigeģʽ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDisplay extends AbstractDisplay{
	private BufferedReader reader;
	private String filePath;
	
	public FileDisplay(String filePath){
		this.filePath=filePath;
		try {
			reader=new BufferedReader(new FileReader(new File(this.filePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void beforeDisplay() {
		System.out.println("file before");
	}

	@Override
	public void goingDisplay() {
		System.out.println("file going ");
		try {
			reader.mark(100);
			String str=null;
			while((str=reader.readLine())!=null){
				System.out.println(str);
			}
			reader.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void afterDisplay() {
		System.out.println("file after");
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
