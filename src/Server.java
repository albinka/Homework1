import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Server extends JFrame implements Runnable{
	
	private ServerSocket s;
	private Socket client;
	
	private Player players [];
	
	private JTextArea console;
	private JTextField input;
	
	public Server(int maxClients) throws IOException {
		
		s = new ServerSocket(20000);
		players = new Player[maxClients];
		
		//Setting up the JFrame
		this.setTitle("Server");
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		console = new JTextArea(20,20);
		input = new JTextField();
		this.add(console);
		this.add(input, "South");
		
		this.setVisible(true);
	}

	public void run() {		

				//Wait for all clients to connect
				for (int i = 0; i < players.length; i++) {
					try {
						
						//When a client connects, create a new thread that handles the client
						players[i] = new Player(s.accept());
						new Thread(players[i]).start();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					console.setText(console.getText() + "Client connected\n");
					console.setText(console.getText() + "Number of clients: " + (i+1) + "\n");
				}
				
				//Start the game with all connected players
				console.setText(console.getText() + "Game is full! Starting....");
				new Game(players);
	}			
}
