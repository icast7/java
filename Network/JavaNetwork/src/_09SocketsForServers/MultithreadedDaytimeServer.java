package _09SocketsForServers;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultithreadedDaytimeServer {
	public final static int PORT =  13;
	
	public static void main(String[] args){
		try (ServerSocket server = new ServerSocket(PORT)){ 
			while(true){
				try {
					Socket socket = server.accept();
					Thread task = new DaytimeThread(socket);
					task.start();
				} catch (IOException ex){}
			}
		} catch (IOException ex){
			System.err.println("Couldn't start server.");
		}
	}

	private static class DaytimeThread extends Thread {
		private Socket socket;
		DaytimeThread(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run(){
			try {
				Writer out = new OutputStreamWriter(socket.getOutputStream());
				Date now = new Date();
				out.write(now.toString()+"\r\n");
				out.flush();
			} catch (IOException ex){
				System.err.println(ex);
			} finally {
				try {
					socket.close();
				} catch (IOException e){
					//Ignore
				}
			}
		}
	}
}
