package SanShuJu_2;

import java.io.IOException;
import java.io.OutputStream;

public interface Framer {
	void frameMsg(byte [] msg,OutputStream out) throws IOException;	//��֡����������Ϣд������
	byte [] nextMsg() throws IOException;		//��ȡ��һ֡����Ϣ
}
