package aboutIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputOutPut {
	public static void main(String[] args) throws IOException {
		File file1=new File("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����\\File1.txt");
		OutputStream out=new FileOutputStream(file1,true); 	//outputstream�Ǹ�������,����һ�����Զ�ˢ�µ������
																								//Ĭ���Զ�ˢ�£����ر������ٴ��ļ����������
		byte [] bs="666666".getBytes();
		out.write(bs, 0, bs.length);
		
		out.flush();
		out.close();
		
		InputStream in=new FileInputStream(file1);
		byte[] bs2=new byte[bs.length];
		while(in.read(bs2)!=-1){	//read��������������᷵��-1��һ�������鹻�ã�����ȫ���ꣻһ�������鲻����û�ط��ź󷵻�-1
			String s=new String(bs2);
			System.out.println(s);
		}
		
		in.close();
	}
}
