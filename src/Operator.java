import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Operator {
	public volatile static ArrayList<Player> players;
	static volatile Queue<Player> queue;
	static Wheel wheel;
	static Thread wheelThread;
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {	
		String fileName= "./src/input1.txt";
		if(fileName.equals("./src/input1.txt")) { 
			PrintStream out = new PrintStream(new FileOutputStream("output1.txt"));
			System.setOut(out);
		}else {
			PrintStream out = new PrintStream(new FileOutputStream("output2.txt"));
			System.setOut(out);
		}
		
		// first line -> max wait time
		// second line -> total players count 
		// third line till the end of the file -> the player threads' info  (thread id , Waiting time )
		queue = new LinkedList<Player>(); 
		ArrayList<String> lines = HelperFunctions.OpenFile(fileName);
		players = new ArrayList<Player>();
		int maxWaitingTime = Integer.parseInt(lines.get(0)) ;
		int playersCount = Integer.parseInt(lines.get(1)) ;
		
		wheel = new Wheel(maxWaitingTime);
		wheelThread = new Thread(wheel);
		wheelThread.start();
		


		for (int i=2;i<lines.size();i++) { //instantiate player thread here
			String[] playerProperties = lines.get(i).split(",");
			Player playerThread = new Player( Integer.parseInt(playerProperties[0]) , Integer.parseInt(playerProperties[1])  );
			Thread p = new Thread(playerThread);
			p.start();
			players.add(playerThread);
			
			System.out.println(playerProperties[0]+" "+playerProperties[1]);
		}
		
		
		while(true) {
			if(players.size()==0) {
				break;
			}
			if((wheel.players.size()<5 && wheel.running==false) && queue.size()>0) {
				Player first = queue.poll();
				wheel.loadPlayers(first);
			}
			if(wheel.capacity==0 && wheel.running==false) {
				wheel.running = true;
				System.out.println("Wheel is full, Let's go for a ride ");
				wheelThread.interrupt();
			}
		}
	}
	
	public static void queueNextRide(Player p) {
		System.out.println("passing player: "+p.id+" to the operator");
		queue.add(p);

	}
	
	public static void startTheProcess(){
		try {
			wheel.running = false;
			wheel.capacity=5;
			Thread.sleep(wheel.maxWaitingTime);
			wheel.running = true;
			System.out.println("wheel end sleep");
			if(players.size()>0&&wheel.players.size()>0)
				wheel.runRide();

		} catch (InterruptedException e) {
			
			wheel.running = true;
			if(players.size()>0)
				wheel.runRide();
		}
	}
	
	
}
