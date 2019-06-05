package aboutIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputOutPut {
	public static void main(String[] args) throws IOException {
		File file1=new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试\\File1.txt");
		OutputStream out=new FileOutputStream(file1,true); 	//outputstream是个抽象类,创建一个不自动刷新的输出流
																								//默认自动刷新，即关闭流后再打开文件内内容清空
		byte [] bs="666666".getBytes();
		out.write(bs, 0, bs.length);
		
		out.flush();
		out.close();
		
		InputStream in=new FileInputStream(file1);
		byte[] bs2=new byte[bs.length];
		while(in.read(bs2)!=-1){	//read方法有两种情况会返回-1，一种是数组够用，内容全读完；一种是数组不够大，没地方放后返回-1
			String s=new String(bs2);
			System.out.println(s);
		}
		
		in.close();
	}
}
