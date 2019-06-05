package SanShuJu_2;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LengthFramer implements Framer{		//基于长度的成帧法
	private DataInputStream in;
	
	public static final int MaxMsgLen=65535;//一帧的最大长度
	public static final int ByteMask=0xff;
	public static final int ShortMask=0xffff;
	public static final int ByteShift=8;
	
	public LengthFramer(InputStream in) throws IOException{
		this.in=new DataInputStream(in);
	}
	
	public void frameMsg(byte[] msg, OutputStream out) throws IOException {
		if(msg.length>MaxMsgLen)
			throw new IOException("消息过长，超过65535");
		out.write((msg.length>>ByteShift)&ByteMask);
		out.write(msg.length&ByteMask);
		out.write(msg);
		out.flush();
	}

	public byte[] nextMsg() throws IOException {
		int lenth;
		try {
			lenth=in.readUnsignedShort();
		} catch (EOFException e) {
			return null;//没有任何消息，空
		}
		
		byte[] msg=new byte[lenth];
		in.readFully(msg);
		return msg;
	}


}
