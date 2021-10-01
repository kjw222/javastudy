package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	static int PORT = 6000;		//포트 num 6000
	static Socket socket = null;	//통신 담당. in, out  담당.
	static ServerSocket serverSocket = null;	//서버이므로 클라이언트에서 연결 요청이 오면 소켓을 생성 하는 서버소켓. 포트와 바인드.
	static List<PrintWriter> listWriters = new ArrayList<PrintWriter>();	//어레이 리스트에 값 저장.
	
	public static void main(String[] args) {
		
		try {
			serverSocket = new ServerSocket();		//서버소켓 생성.
			String hostAddress = InetAddress.getLocalHost().getHostAddress();	
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));		//포트와 bind. 
			log("연결 대기 : "+hostAddress+" : "+PORT);	
			
			while(true) {		
				socket = serverSocket.accept();		//클라이언트 연결 요청이 오면 소켓 생성.
				new ChatServerThread(socket, listWriters).start();
			}
			
		} catch (IOException e){
			log("error:" + e);		
		} finally {
			// 5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {		
					serverSocket.close();
				}
			} catch (IOException ex) {
				log("error:" + ex);
			}
		}
	}

	private static void log(String string) {
		System.out.println("[HttpServer " + Thread.currentThread().getId() + "]" + string);
	}
		

}