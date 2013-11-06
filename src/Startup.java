import java.io.IOException;

//Start the server and 3 Clients
public class Startup {
	

	public static void main(String[] args) throws IOException {
		
		new Thread(new Server(3)).start();		
		
		new Thread(new Client("1")).start();
		new Thread(new Client("2")).start();
		new Thread(new Client("3")).start();

	}

}
