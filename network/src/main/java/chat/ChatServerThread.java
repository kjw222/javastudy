package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickname;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	List<PrintWriter> listWriters = null;

	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	@Override
	public void run() {
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			while ( true ) {
				String request = br.readLine();
					if(request == null) {
						doQuit(pw);
						break;
					}
					
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} 
				else if ("message".equals(tokens[0])) {
					if(tokens.length < 2) {
						continue;
					}

					doMessage(tokens[1]);
				}
				else if ("quit".equals(tokens[0])) {
					doQuit(pw);
				} 
				else {
					log("에러 : 알수 없는 요청 (" + tokens[0] + ")");
				}
			}
			
			
		} catch(IOException e) {
			log("error:" + e);
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void doQuit(Writer writer) {
		removeWriter (writer);
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast (data);
		
		log(nickname + "으로부터 연결 끊임");
	}
	
	private void removeWriter (Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}
	private void doMessage(String string) {
		broadcast(this.nickname + ":" + string);
	}
	
	private void doJoin(String nickName, PrintWriter writer) {
		this.nickname = nickName;
		
		String data = nickName + " 님이 참여하였습니다.";
		broadcast(data);
		addWriter(writer);
		log(nickname + " 님이 참여하였습니다.");
		System.out.println(nickname + " 님이 참여하였습니다.");
		pw.flush();
		
	}
	
	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}
	
	static void log(String string) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId() + "]" + string);
		
	}
	
	private void broadcast (String data) {
		synchronized (listWriters) {
			for (PrintWriter writer : listWriters) {
				writer.println (data);
				writer.flush();
			}
		}
	}

}