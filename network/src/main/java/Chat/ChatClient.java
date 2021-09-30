package Chat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class ChatClient {

	public static void main(String[] args) {
		
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		int PORT = 6000;
		String IP = "127.0.0.1";
		Scanner scanner = new Scanner(System.in);
		
		try {
			socket = new Socket(IP,PORT);
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inMsg = br.readLine();
				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
