package aboutSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class aboutTCPServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		try {
			String [] answer={"hi!","i am Tom and you ?","ok "};
			
			ServerSocket server=new ServerSocket(8888);
			
			Socket socket=server.accept();
			
			InputStream in=socket.getInputStream();
			DataInputStream dataIn=new DataInputStream(in);
			
			OutputStream out=socket.getOutputStream();
			DataOutputStream dataOut=new DataOutputStream(out);
			
			int i=0;
			while(true){
				String str=dataIn.readUTF();
				System.out.println("client request :"+str);
				
				dataOut.writeUTF(answer[i++]);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("client is broken!");
		}
		
	}
}
