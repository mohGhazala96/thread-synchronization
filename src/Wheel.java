import java.util.ArrayList;

public class Wheel extends Thread {

	int capacity;
	int playerOnBoardCount;
	int maxWaitingTime;
	ArrayList <Player> players;
	
	@SuppressWarnings("static-access")
	public Wheel(int capacity,int playerOnBoardCount, ArrayList <Player> players,int maxWaitingTime  ) {
		this.capacity = capacity;
		this.playerOnBoardCount = playerOnBoardCount;
		this.players=players;
		this.maxWaitingTime = maxWaitingTime;
		try {
			this.sleep(maxWaitingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void loadPlayers(Player player) {
		players.add(player);
	}
	public void runRide() {
		for (int i=0;i<players.size();i++) 
			players.get(i).onBoardFlag=true;
		
		
	}
	@SuppressWarnings("static-access")
	public void endRide() {
		for (int i=0;i<players.size();i++) 
			players.get(i).onBoardFlag=false;
		int playersSize=players.size()-1;
		for (int i=playersSize;i>=0;i--) 
			players.remove(i);
		try {
			this.sleep(maxWaitingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
