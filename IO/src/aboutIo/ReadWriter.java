package aboutIo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReadWriter {
	public static void main(String[] args) throws IOException {
		Reader reader=new FileReader(new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试\\File1.txt"));
		Writer writer=new FileWriter(new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试\\File2.txt"),true);
		
		char [] cs=new char[20];
		while(reader.read(cs, 0, cs.length)!=-1){
			writer.write(cs);
		}
		
		reader.close();
		writer.close();
	}
}
