package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final int PORT = 6000;
	private static final String IP = "127.0.0.1";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		PrintWriter pw = null;
		BufferedReader br = null;

		try {
			//1. 키보드 연결
			scanner = new Scanner(System.in);
			
			//2. socket 생성
			socket = new Socket();
			
			//3. 연결
			socket.connect(new InetSocketAddress(IP, PORT));
			System.out.println("connected");

			//4. reader/writer 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 5. join 프로토콜
			String nickname = "";
			while (true) {
				System.out.print(">>  닉네임입력");
				nickname =scanner.nextLine();
					if ("".equals(nickname) == false) {
						break;
					}
			}
			pw.println("join:" + nickname);

			// 6.ChatClientThread 시작
			new ChatClientThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String in = scanner.nextLine();

				if (in == null) {
					continue;
				}
				if ("quit".equals(in) == true) {
				//8. quit 프로토콜 처리
					pw.println("quit:" + in);
					break;
				} else {
				//9. 메시지 처리
					pw.println("message:" + in);
				}
			}

		} catch (Exception e) {
			System.out.println("error : " + e);
		} finally {
			//10. 자원정리
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}if (scanner != null) {
					scanner.close();
				}
			} catch (IOException ex) {
				System.out.println("error : " + ex);
			}
		}
	}

	public static void log(String string) {
		// TODO Auto-generated method stub
		
	}


}