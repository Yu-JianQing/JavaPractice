package aboutIo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataInOut {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����\\File0.txt");
		OutputStream out=new FileOutputStream(file);
		DataOutputStream dataOut=new DataOutputStream(out);
		
		dataOut.writeUTF("xxxxxxxxxxx");
		dataOut.writeInt(6);
		
		dataOut.close();
		
		InputStream in=new FileInputStream(file);
		DataInputStream dataIn=new DataInputStream(in);
		
		String s=dataIn.readUTF();
		int i=dataIn.readInt();
		System.out.println(s+i);
	}
}