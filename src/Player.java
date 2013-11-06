import java.io.*;
import java.net.*;
import java.util.*;

public class Player implements Runnable{
        private Socket socket;		
        private String name;
        private String choice;
        private int score;
		private Scanner in;	
		private PrintWriter pw;

        public Player (Socket s) {
                this.name = "";
                this.socket = s;
                this.score = 0;                
                try {
					in = new Scanner(s.getInputStream());
					pw = new PrintWriter(s.getOutputStream(),true);
				} catch (IOException e) {
					e.printStackTrace();
				}				
        }
        
        public String getChoice() {
        	return choice;        	
        }
        
        public void clearChoice() {
        	choice = null;
        }
        
        public int getScore(){
                return score;
        }
        
        public String getName() {
                return name;
        }
        
        public void incrementScore(int a) {
                score += a;
        }


        //Constantly check if the player has made choice
		public void run() {
			while (true) {
				if(in.hasNext()) {					
					choice = in.nextLine();					
				}
			}
			
		}

}