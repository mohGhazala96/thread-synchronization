import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.FileReader;
import java.io.BufferedReader;

public class HelperFunctions {
	public static ArrayList<String> OpenFile(String path) throws IOException { 
		FileReader fr = new FileReader(path); 
		BufferedReader textReader = new BufferedReader(fr); 
		// single character
		int numberOfLines = readLines(path );

		ArrayList<String> textData = new ArrayList<String>();
		int i;
		for (i = 0; i < numberOfLines; i++) { 
			String currentLine = textReader.readLine();
			if(!currentLine.equals(""))
				textData.add( currentLine);
			
			
		}
		textReader.close();
		return textData;
	}
	static int readLines(String path) throws IOException {
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);

		@SuppressWarnings("unused")
		String aLine;
		int numberOfLines = 0;
		while ((aLine = bf.readLine()) != null) {
			numberOfLines++;
		}
		bf.close();

		return numberOfLines;
	}

	public static void  main(String[] args) throws IOException {
		ArrayList<String> lines = OpenFile("./src/input1.txt");
		for (int i=0;i<lines.size();i++) {
			System.out.println(lines.get(i));
		}
		

	}

}
