package SanShuJu_2;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DelimFramer implements Framer{	//基于定界符的成帧法
	private InputStream in;
	private static final byte Delimiter='\n';//定界符
	
	public DelimFramer(InputStream in){
		this.in=in;
	}
	
	public void frameMsg(byte[] msg, OutputStream out) throws IOException {
		for(byte b:msg)
			if(b==Delimiter)
				throw new IOException("消息里包含定界符");
		out.write(msg);
		out.write(Delimiter);
		out.flush();
	}

	public byte[] nextMsg() throws IOException {
		ByteArrayOutputStream bOut=new ByteArrayOutputStream();
		int next;
		
		while((next=in.read())!=Delimiter){
			if(next==-1){//判断有没有读完
				if(bOut.size()==0){//如果没有字节可读
					return null;		//返回空
				}else{		//还没全部读完就遇到流的终点也就是说还没遇到定界符但是流到终点了
					throw new EOFException("只接收了没遇到分隔符的部分消息");
				}
			}
			bOut.write(next);	//没读完继续写
		}
		return bOut.toByteArray();
	}

}
