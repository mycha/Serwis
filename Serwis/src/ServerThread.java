import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;


public class ServerThread extends Thread {
	private Socket socket = null;
	private SerwerSerwis server = null;
	private int ID = -1;
	private DataInputStream datain = null;
	private DataOutputStream dataout = null;
	private ObjectOutputStream objectOut = null;
	private String name = null;
	private String password;
	private Boolean blad = false ;
	
	
	public ServerThread(SerwerSerwis serwerSerwis, Socket socket) {
		server = serwerSerwis;
		this.socket = socket;
		ID = socket.getPort(); //pobierz id klienta
	}
	public void run(){
		String command;
		List<String> msg;
		System.out.println("Proba polaczenia : "+ ID);
		try {
			name =  datain.readUTF();
			password =  datain.readUTF();
			System.out.println(name + password);
		} catch (IOException e1) {	
			e1.printStackTrace();
		}
		MySQL mysql = new MySQL(name);
		if(password.equals(mysql.getPassword())){
			System.out.println("Zalogowano");
			blad = true;
			try {
				dataout.writeBoolean(blad);
				dataout.flush();
				dataout.writeInt(ID);
				dataout.flush();
			} catch (IOException e) {
					e.printStackTrace();
			}  
			
		while(true){
			try{
				command = datain.readUTF();
				System.out.println(command);
				msg=mysql.Command(command);
				objectOut.writeObject(msg);
				System.out.println(msg);
				
			}catch(IOException e){	} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			
		}else{
			System.out.println("b��dny login lub has�o");
			blad = false;
			try {
				dataout.writeBoolean(blad);
				dataout.flush();
				dataout.writeInt(0);
				dataout.flush();
			} catch (IOException e) {
					e.printStackTrace();
			}
			try {
				close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
	}
	public void open() throws IOException{
		datain = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		dataout = new DataOutputStream(socket.getOutputStream());
		objectOut = new ObjectOutputStream(socket.getOutputStream());
	}
	public void close() throws IOException{
		if (socket != null)    socket.close();
	    if (datain != null)  datain.close();
	}
	
}
