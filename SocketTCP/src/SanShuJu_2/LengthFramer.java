package SanShuJu_2;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LengthFramer implements Framer{		//���ڳ��ȵĳ�֡��
	private DataInputStream in;
	
	public static final int MaxMsgLen=65535;//һ֡����󳤶�
	public static final int ByteMask=0xff;
	public static final int ShortMask=0xffff;
	public static final int ByteShift=8;
	
	public LengthFramer(InputStream in) throws IOException{
		this.in=new DataInputStream(in);
	}
	
	public void frameMsg(byte[] msg, OutputStream out) throws IOException {
		if(msg.length>MaxMsgLen)
			throw new IOException("��Ϣ����������65535");
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
			return null;//û���κ���Ϣ����
		}
		
		byte[] msg=new byte[lenth];
		in.readFully(msg);
		return msg;
	}


}
