package SiCompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CompressClient {
	public static final int BufSize=256;
	
	private static void sendBytes(Socket socket,InputStream in) throws IOException{
		OutputStream out=socket.getOutputStream();
		
		int bytesRead;
		byte [] buf=new byte[BufSize];
		while((bytesRead=in.read(buf))!=-1){
			out.write(buf,0,bytesRead);
			System.out.println("write a msg");
		}
		
		socket.shutdownOutput();
	}
	
	public static void main(String[] args) throws IOException {
		int port=9557;
		File file =new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试\\file1.txt");
		
		FileInputStream fInStream=new FileInputStream(file);
		FileOutputStream fOutStream=new FileOutputStream(file.getName()+"5.txt");//in和out不是同一个文件
		
		Socket socket=new Socket("127.0.0.1", port);
		
		sendBytes(socket, fInStream);
		
		InputStream in=socket.getInputStream();
		
		int bytesRead;
		byte [] buf=new byte[BufSize];
		while((bytesRead=in.read(buf))!=-1){
			fOutStream.write(buf,0,bytesRead);
			System.out.println("read a msg");
		}
		
		socket.close();
		fInStream.close();
		fOutStream.close();
	}
}
