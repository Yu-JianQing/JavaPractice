package JiuFu_3;

import java.io.DataInputStream;
import java.net.URL;

public class SynContentImp  implements Content{
	private byte [] contentbytes;
	
	public SynContentImp(String urlstr){
		System.out.println(Thread.currentThread().getName()+" get "+urlstr);
		
		try {
			URL url = new URL(urlstr);
			DataInputStream in=new DataInputStream(url.openStream());
			byte [] buffer=new byte[1];
			int index=0;
			try {
				while(true){
					int c=in.readUnsignedByte();
					if(buffer.length<=index){
						byte [] largerbuffer=new byte[buffer.length*2];
						System.arraycopy(buffer, 0, largerbuffer, 0, index);
						buffer=largerbuffer;
//						System.out.println("larger byffer lenth is "+buffer.length);
					}
					buffer[index++]=(byte)c;
//					System.out.println("get "+index+" bytes from "+urlstr);
				}
			} catch (Exception e) {
			}finally{
				in.close();
			}
			this.contentbytes=new byte[index];
			System.arraycopy(buffer, 0, contentbytes, 0, index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] getBytes() {
		return contentbytes;
	}

}
