import java.util.ArrayList;

public class Wheel implements Runnable{

	int capacity = 5;
	int playerOnBoardCount = 0;
	int maxWaitingTime;
	boolean running =false;
	ArrayList <Player> players;
	

	public Wheel(int maxWaitingTime  ) {
		this.players = new ArrayList<Player>();
		this.maxWaitingTime = maxWaitingTime;

		System.out.println("wheel start sleep");
		
	}
	public synchronized void loadPlayers(Player player) {
		capacity--;
		System.out.println("Player "+player.id+" on board, capacity: "+(5-capacity)); //Capacity should stand for "empty spots" but apparently it was meant
																					//as something else here. I will follow your example.
		players.add(player);
	}
	public void runRide() {
		System.out.println("Wheel is full, Let's go for a ride ");
		System.out.println("Threads in this ride are: "+players.toString());
		for (int i=0;i<players.size();i++) {
			System.out.print(players.get(i).id+" ");
			players.get(i).onBoardFlag=true;
		}
		System.out.println("");
		endRide();
		
		
	}
	public void endRide() {
		for (int i=0;i<players.size();i++) 
			players.get(i).onBoardFlag=false;
		int playersSize=players.size()-1;
		for (int i=playersSize;i>=0;i--) {
			Operator.players.remove(players.get(i));
			players.remove(i);
		}
		this.running=false;
		startTheProcess();
		
	}
	
	void startTheProcess(){
		try {
			this.capacity=5;
			Thread.sleep(maxWaitingTime);
			System.out.println("wheel end sleep");
			this.runRide();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.startTheProcess();
	}


}
