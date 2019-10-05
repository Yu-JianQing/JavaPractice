package aboutSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class aboutTCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		try {
			String [] msg={"hello!","who are you ?","i am jerry"};
			
			Socket socket=new Socket("127.0.0.1", 8888);
			
			InputStream in=socket.getInputStream();
			DataInputStream dataIn=new DataInputStream(in);
			
			OutputStream out=socket.getOutputStream();
			DataOutputStream dataOut=new DataOutputStream(out);
			
			for (int i = 0; i < msg.length; i++) {
				dataOut.writeUTF(msg[i]);
				
				String str=dataIn.readUTF();
				
				System.out.println("server answer:"+str);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("server socket is broken!");
		}
		
	}
}
