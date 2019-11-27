package ´°¿ÚÄ£Ê½;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataBase {
	private DataBase(){}
	
	public static Properties getProperties(String pname) throws Exception{
		Properties properties=new Properties();
		
		properties.load(new FileInputStream(new File(pname)));
		
		return properties;
	}
}
