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
		File file=new File("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����\\File0.txt");
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
		
		
		/*��ֻ�ܶ�һ�Σ������ָ�����������ˣ�û���ٶ��ˡ������з������*/
//		String s;
//		while((s=bReader.readLine())!=null){
//			System.out.println(s);
//		}
		
		bReader.close();
	}
}