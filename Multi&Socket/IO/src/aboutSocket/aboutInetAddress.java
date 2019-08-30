package aboutSocket;

import java.io.IOException;
import java.net.InetAddress;

public class aboutInetAddress {
	public static void main(String[] args) throws IOException {
		InetAddress address=InetAddress.getByName("www.baidu.com");
		System.out.println(address);
		
		String name=address.getHostName();
		String ip=address.getHostAddress();
		
		System.out.println("”Ú√˚£∫"+name+"   ip:"+ip);
		
		InetAddress address2=InetAddress.getLocalHost();
		
		System.out.println(address2);
		
	}
}
