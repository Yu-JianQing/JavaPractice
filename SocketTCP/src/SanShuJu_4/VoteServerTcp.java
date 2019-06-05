package SanShuJu_4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import SanShuJu_2.Framer;
import SanShuJu_2.LengthFramer;
import SanShuJu_3.VoteMsg;
import SanShuJu_3.VoteMsgBinCoder;
import SanShuJu_3.VoteMsgCoder;

public class VoteServerTcp {
	public static void main(String[] args) throws IOException {
		int port=9999;
		ServerSocket serverSocket=new ServerSocket(port);
		VoteMsgCoder coder=new VoteMsgBinCoder();
		VoteService service=new VoteService();
		
		while(true){
			Socket clntSocket=serverSocket.accept();
			System.out.println("�ͻ��˵ĵ�ַ�ǣ�"+clntSocket.getRemoteSocketAddress());
			
			InputStream in=clntSocket.getInputStream();
			Framer framer=new LengthFramer(in);
			
			byte[] req;
			while((req=framer.nextMsg())!=null){	//���������ж�����Ϣ֡
				System.out.println("���յ��ͻ��˵����󳤶��ǣ�"+req.length);
				System.out.println("������Ϣ�ǣ�"+new String(req).toString());
				
				VoteMsg responseMsg=service.handleRequest(coder.fromWire(req));	//��������Ϣ����
				framer.frameMsg(coder.toWire(responseMsg), clntSocket.getOutputStream());	//��װ�ظ���Ϣ֡�����������
			}
			
			System.out.println("�������ر�����");
			clntSocket.close();
		}
	}
}