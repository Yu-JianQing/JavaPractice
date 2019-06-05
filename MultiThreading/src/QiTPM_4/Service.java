package QiTPM_4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Service {
	public static void service(Socket clientSocket) throws IOException{
		System.out.println(Thread.currentThread().getName()+": service "+clientSocket+" begin");
		try {
			DataOutputStream outputStream=new DataOutputStream(clientSocket.getOutputStream());
			outputStream.writeBytes("HTTP/1.0 200 ok\r\n");
			outputStream.writeBytes("Content-type: text/html\r\n");
			outputStream.writeBytes("\r\n");
			outputStream.writeBytes("<html><head><title>CountDown</title></head><body>");
			outputStream.writeBytes("<h1>CountDown Start!</h1>");
			for (int i = 10; i >=0; i--) {
				System.out.println(Thread.currentThread().getName()+":countdown "+i);
				outputStream.writeBytes("<h1>"+i+"</h1>");
				outputStream.flush();
				Thread.sleep(1000);
			}
			outputStream.writeBytes("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			clientSocket.close();
		}
		System.out.println(Thread.currentThread().getName()+": service "+clientSocket+" done");
	}
}
