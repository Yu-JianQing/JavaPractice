package ErTaoJieZi;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> netfaceList=NetworkInterface.getNetworkInterfaces();
			if(netfaceList==null)
				System.out.println("û������ӿ�");
			else{
				while(netfaceList.hasMoreElements()){
					NetworkInterface netface=netfaceList.nextElement();
					System.out.println("����ӿڵ�������"+netface.getName()+"�����ǣ�");
					Enumeration<InetAddress> addressList=netface.getInetAddresses();
					if(!addressList.hasMoreElements())
						System.out.println("�˽ӿ�û�������ַ");
					while(addressList.hasMoreElements()){
						InetAddress address=addressList.nextElement();
						System.out.print("\t�����ַ�ǣ�"+(address instanceof Inet4Address?"IPV4":"IPV6"));
						System.out.println(":"+address.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			System.out.println("");
		}
		
		String [] hosts={"www.baidu.com","129.35.69.7","wjeijd.bassd"};
		for(String host:hosts){
			try {
				System.out.println(host+":");
				InetAddress[] addressesList=InetAddress.getAllByName(host);
				for(InetAddress address:addressesList)
					System.out.println("\t"+address.getHostName()+"/"+address.getHostAddress());
			} catch (UnknownHostException e) {
				System.out.println("û�ҵ����� "+host+" �������ַ");
			}
		}
	}
}
