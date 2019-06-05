package aboutIo;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayInOut {
	public static void main(String[] args) throws IOException {
		CharArrayWriter charArrayWriter=new CharArrayWriter();
		
		char[] cbuf="8888888888".toCharArray();
		charArrayWriter.write(cbuf);
		
		charArrayWriter.close();
		
		CharArrayReader charArrayReader=new CharArrayReader(charArrayWriter.toCharArray());
		
		char[] cs=new char[charArrayWriter.toCharArray().length];
		charArrayReader.read(cs);
		
		System.out.println(new String(cs));
		
		charArrayReader.close();
	}
}
