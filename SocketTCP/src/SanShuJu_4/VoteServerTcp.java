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
			System.out.println("客户端的地址是："+clntSocket.getRemoteSocketAddress());
			
			InputStream in=clntSocket.getInputStream();
			Framer framer=new LengthFramer(in);
			
			byte[] req;
			while((req=framer.nextMsg())!=null){	//从输入流中读出信息帧
				System.out.println("接收到客户端的请求长度是："+req.length);
				System.out.println("请求信息是："+new String(req).toString());
				
				VoteMsg responseMsg=service.handleRequest(coder.fromWire(req));	//对请求信息解码
				framer.frameMsg(coder.toWire(responseMsg), clntSocket.getOutputStream());	//封装回复信息帧并放入输出流
			}
			
			System.out.println("服务器关闭连接");
			clntSocket.close();
		}
	}
}
