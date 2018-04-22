import java.util.ArrayList;

public class Wheel extends Thread {

	int capacity;
	int playerOnBoardCount;
	int maxWaitingTime;
	ArrayList <Player> players;
	
	public Wheel(int capacity,int playerOnBoardCount, ArrayList <Player> players,int maxWaitingTime  ) {
		this.capacity = capacity;
		this.playerOnBoardCount = playerOnBoardCount;
		this.players=players;
		this.maxWaitingTime = maxWaitingTime;
		
	}
	public void loadPlayers() {
		
	}
	public void runRide() {
		
	}
	public void endRide() {
		
	}


}
