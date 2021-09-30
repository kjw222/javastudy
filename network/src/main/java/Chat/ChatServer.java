package Chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	 

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		int PORT = 6000;
		Scanner scanner = new Scanner(System.in);
		
		try {
			serversocket = new ServerSocket(PORT);
			System.out.println("연결 대기중....");
			
			socket = serversocket.accept();
			System.out.println("연결 완료");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			
			while(true) {
				
				String inMsg = in.readLine();
				if(inMsg.equals("bye")) {
					System.out.println("클라이언트가 나갔습니다.");
					break;
				}
				
				//정상 메시지인 경우
				System.out.println("클라이언트 : "+ inMsg);
				System.out.println(">>");
				String outMsg = scanner.nextLine();
				bw.write(outMsg+"/n");
				bw.flush();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			scanner.close();
			br.close();
			bw.close();
			socket.close();
			serversocket.close();
		}
	}

}
