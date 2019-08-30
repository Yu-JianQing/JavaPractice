package WuNIO;

import java.io.IOException;
import java.nio.channels.SelectionKey;

public interface TCPProtocol {
	void handleAccept(SelectionKey key) throws IOException;//当信道上发生的事件是accept时，调用此方法处理
	void handleRead(SelectionKey key) throws IOException;//当信道上发生的事件是read时，调用此方法处理
	void handleWrite(SelectionKey key) throws IOException;//当信道上发生的事件是write时，调用此方法处理
}
