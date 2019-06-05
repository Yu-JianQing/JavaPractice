package aboutIo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccessStream {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����\\File2.txt");
		RandomAccessFile rAccessFile=new RandomAccessFile(file, "rw");
		
		int data[]={1,2,3,4,5,6,7,8,9,0};
		for (int i = 0; i < data.length; i++) 
			rAccessFile.writeInt(data[i]);
		
		System.out.println(rAccessFile.length()+"   "+data.length);
		
		for (int i = 0; i < data.length; i++) {
			rAccessFile.seek(i*4);
			System.out.println(rAccessFile.readInt());
		}
		
		rAccessFile.seek(0);
		String string=rAccessFile.readLine();
		byte[] bytes=string.getBytes("iso-8859-1");
		System.out.println(new String(bytes));
		
		rAccessFile.close();
	}
}
