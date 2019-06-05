package SanShuJu_2;

import java.io.IOException;
import java.io.OutputStream;

public interface Framer {
	void frameMsg(byte [] msg,OutputStream out) throws IOException;	//成帧方法，将信息写入流中
	byte [] nextMsg() throws IOException;		//获取下一帧的消息
}
