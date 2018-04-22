import java.io.IOException;
import java.util.ArrayList;

public class Operator {
	public static ArrayList<Player> players;
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {	
		// first line -> max wait time
		// second line -> total players count 
		// third line till the end of the file -> the player threads' info  (thread id , Waiting time )
		ArrayList<String> lines = HelperFunctions.OpenFile("./src/input1.txt");
		players = new ArrayList<Player>();
		int maxWaitingTime = Integer.parseInt(lines.get(0)) ;
		int playersCount = Integer.parseInt(lines.get(1)) ;

		for (int i=2;i<lines.size();i++) { //instantiate player thread here
			String[] playerProperties = lines.get(i).split(",");
//			Player playerThread = new Player( Integer.parseInt(playerProperties[0]) , Integer.parseInt(playerProperties[1])  );
//			players.add(playerThread);
			System.out.println(playerProperties[0]+" "+playerProperties[1]);
		}
		
		
	}
}
