package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	Socket socket;

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			while(true) {
				String msg = br.readLine();
				System.out.println("<<" + msg);
			}
		} catch (IOException e) {
			ChatClient.log("error:" + e);
		}
	}

	public ChatClientThread(Socket socket) {
		this.socket  = socket;
	}

}