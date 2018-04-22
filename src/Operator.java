import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Operator {
	public volatile static ArrayList<Player> players;
	static volatile Queue<Player> queue;
	static Wheel wheelThread;
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {	
		// first line -> max wait time
		// second line -> total players count 
		// third line till the end of the file -> the player threads' info  (thread id , Waiting time )
		queue = new LinkedList<Player>(); 
		ArrayList<String> lines = HelperFunctions.OpenFile("./src/input2.txt");
		players = new ArrayList<Player>();
		int maxWaitingTime = Integer.parseInt(lines.get(0)) ;
		int playersCount = Integer.parseInt(lines.get(1)) ;
		
		wheelThread = new Wheel(maxWaitingTime);
		Thread t = new Thread(wheelThread);
		t.start();


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
			if(wheelThread.players.size()<5 && wheelThread.running==false && queue.size()>0) {
				Player first = queue.poll();
				wheelThread.loadPlayers(first);
			}
			if(wheelThread.capacity==0 && wheelThread.running==false) {
				System.out.println("Wheel is full, Let's go for a ride ");
//				wheelThread.run();

				wheelThread.runRide();
			}
		}
	}
	
	public static void queueNextRide(Player p) {
		System.out.println("passing player: "+p.id+" to the operator");
		queue.add(p);

	}
	
	
}
