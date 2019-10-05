package aboutSocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class aboutURL {
	public static void main(String[] args) throws IOException {
		URL url=new URL("https://www.baidu.com");
		
		InputStream in=url.openStream();
		
		new Thread(){
			public void run(){
				byte[] b=new byte[1024];
				int i;
				
				try {
					while((i=in.read(b))!=-1){
						System.out.println(new String(b));
					}
				} catch (IOException e) {}
			}
		}.start();//输入流读数据可能会引起堵塞，所以再新线程中读取
		
		
	}
}
