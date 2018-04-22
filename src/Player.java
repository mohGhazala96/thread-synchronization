
public class Player implements Runnable{
	int id;
	int waitingTime;
	public boolean onBoardFlag;
	public boolean rideCompleteFlag;

	public Player(int id, int waitingTime ) {
		this.waitingTime = waitingTime;
		this.id=id;
		this.onBoardFlag =false;
		this.rideCompleteFlag =false;

		//calls operator

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//A Player thread is initially put to sleep according to its waiting time.
		try {
			Thread.sleep(waitingTime); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("player wakes up: "+this.id);
		Operator.queueNextRide(this);
//		return;
	}
}
