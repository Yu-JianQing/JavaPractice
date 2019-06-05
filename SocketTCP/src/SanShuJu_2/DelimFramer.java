package SanShuJu_2;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DelimFramer implements Framer{	//���ڶ�����ĳ�֡��
	private InputStream in;
	private static final byte Delimiter='\n';//�����
	
	public DelimFramer(InputStream in){
		this.in=in;
	}
	
	public void frameMsg(byte[] msg, OutputStream out) throws IOException {
		for(byte b:msg)
			if(b==Delimiter)
				throw new IOException("��Ϣ����������");
		out.write(msg);
		out.write(Delimiter);
		out.flush();
	}

	public byte[] nextMsg() throws IOException {
		ByteArrayOutputStream bOut=new ByteArrayOutputStream();
		int next;
		
		while((next=in.read())!=Delimiter){
			if(next==-1){//�ж���û�ж���
				if(bOut.size()==0){//���û���ֽڿɶ�
					return null;		//���ؿ�
				}else{		//��ûȫ����������������յ�Ҳ����˵��û������������������յ���
					throw new EOFException("ֻ������û�����ָ����Ĳ�����Ϣ");
				}
			}
			bOut.write(next);	//û�������д
		}
		return bOut.toByteArray();
	}

}