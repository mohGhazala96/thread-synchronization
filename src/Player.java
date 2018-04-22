
public class Player extends  Thread {
	int id;
	int waitingTime;
	public boolean onBoardFlag;
	public boolean rideCompleteFlag;

	@SuppressWarnings("static-access")
	public Player(int id, int waitingTime ) {
		this.waitingTime = waitingTime;
		this.id=id;
		this.onBoardFlag =false;
		this.rideCompleteFlag =false;
		//A Player thread is initially put to sleep according to its waiting time.
		try {
			this.sleep(waitingTime); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//calls operator
		
	}
}
