import java.io.IOException;
import java.util.ArrayList;

public class Operator {
	public static void main(String[] args) throws IOException {	
		// first line -> max wait time
		// second line -> total players count 
		// third line till the end of the file -> the player threads' info  (thread id , Waiting time )
		ArrayList<String> lines = HelperFunctions.OpenFile("./src/input1.txt");
		for (int i=0;i<lines.size();i++) {
			// instatiate player thread here
			System.out.println(lines.get(i));
		}
		
		
	}
}
