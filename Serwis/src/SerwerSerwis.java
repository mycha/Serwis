import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SerwerSerwis implements Runnable {
	private ServerSocket serwer = null;
	private ServerThread client = null;
	private Thread thread= null;
	public SerwerSerwis(int port){
		try{
			System.out.println("Bindowanie do portu" + port);
			serwer = new ServerSocket(port);
			System.out.println("Serwer dzia�a  : "+ serwer);
			start();
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		SerwerSerwis serwer = new SerwerSerwis( 5000 );

	}
	@Override
	public void run() {
		while(thread!=null){
			try{
				System.out.println("Oczekiwanie na klienta");	
				addThread(serwer.accept());
				
			}catch(IOException ioe){
				
			}
		}
	}
	private void addThread(Socket socket){
		client = new ServerThread(this, socket);
		try{
			client.open();
			client.start();
			
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void start(){
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
	}
	@SuppressWarnings("deprecation")
	public void stop(){
		if(thread!= null){
			thread.stop();
			thread=null;
		}
	}

}
