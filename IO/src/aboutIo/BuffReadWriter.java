package aboutIo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class BuffReadWriter {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试\\File0.txt");
		Reader reader=new FileReader(file);
		Writer writer=new FileWriter(file,true);
		BufferedReader bReader=new BufferedReader(reader);
		BufferedWriter bWriter=new BufferedWriter(writer);
		
		bWriter.write("5555555555555");
		bWriter.newLine();
		
		bWriter.flush();
		bWriter.close();
		
		char [] cs=new char[160];
		while(bReader.read(cs)!=-1){
			System.out.println(new String(cs));
		}
		
		
		/*流只能读一次，读完后指针便在最后面了，没法再读了。可以有方法解决*/
//		String s;
//		while((s=bReader.readLine())!=null){
//			System.out.println(s);
//		}
		
		bReader.close();
	}
}
