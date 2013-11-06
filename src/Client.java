import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Client extends JFrame implements Runnable {

	public String name;
	private Socket s;
	private PrintWriter pw;
	private StringBuilder sb;
	private Scanner in;
	private JButton [] buttons = {new JButton("Rock"), new JButton("Paper"), new JButton("Scissors")};

	public Client(String name) {
		
		//Setting up the JFrame
		this.name = name;
		this.setTitle(name);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,3));
		
		//Adding the buttons
		for (int i = 0; i < buttons.length; i++) {
			this.add(buttons[i]);
			buttons[i].addActionListener(new ButtonListener());
		}

		try {
			// Creates a socket
			s = new Socket("localhost", 20000);
			
			// Get the input and output streams from the socket.
			pw = new PrintWriter(s.getOutputStream(), true);
			in = new Scanner(s.getInputStream());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
	}
	
	//Constantly reads data sent from the server
	public void run() {			
		while(true) {			
			if(in.hasNext()) {				
				System.out.println("Data read");				
			}			
		}		
	}
	
	//Checks which button is pressed
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pw.println(e.getActionCommand());
		}
		
	}
}
