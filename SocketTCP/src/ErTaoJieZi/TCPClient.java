package ErTaoJieZi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		String server="192.0.2.1";
		String msg="echo this!";
		byte [] data=msg.getBytes();
		int serverPort=9999;
		
		Socket socket=new Socket(server,serverPort);
		System.out.println("客户端连接服务器端");
		
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		
		out.write(data);
		
		int totalByteRec=0;
		int byteRec;
		while(totalByteRec<data.length){
			if((byteRec=in.read(data, totalByteRec, data.length-totalByteRec))==-1)
				throw new SocketException("连接已经关闭");
			totalByteRec=totalByteRec+byteRec;
		}
		
		System.out.println("received : "+new String(data));
		
		socket.close();
	}
}
