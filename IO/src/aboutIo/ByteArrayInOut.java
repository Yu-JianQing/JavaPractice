package aboutIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayInOut {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream byteArrayOut=new ByteArrayOutputStream();
		
		byte[] buffer="666666666".getBytes();
		byteArrayOut.write(buffer);
		
		byteArrayOut.close();
		
		ByteArrayInputStream byteArrayIn=new ByteArrayInputStream(byteArrayOut.toByteArray());
		
		byte[] bytes=new byte[byteArrayOut.toByteArray().length];
		while(byteArrayIn.read(bytes)!=-1){
			System.out.println(new String(bytes));
		}
		
		byteArrayIn.close();
	}
}
