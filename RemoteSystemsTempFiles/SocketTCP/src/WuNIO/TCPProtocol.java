package WuNIO;

import java.io.IOException;
import java.nio.channels.SelectionKey;

public interface TCPProtocol {
	void handleAccept(SelectionKey key) throws IOException;//���ŵ��Ϸ������¼���acceptʱ�����ô˷�������
	void handleRead(SelectionKey key) throws IOException;//���ŵ��Ϸ������¼���readʱ�����ô˷�������
	void handleWrite(SelectionKey key) throws IOException;//���ŵ��Ϸ������¼���writeʱ�����ô˷�������
}
