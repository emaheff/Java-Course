import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	// the method get the words from the file and contains the words in a list
	public static List<String> getWordsFromFile() {
		List<String> wordsList = new ArrayList<>();
		try {
			File file = new File("hangManFile.txt");
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				String word = scan.next();
				wordsList.add(word);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problam with opening the file");
		}
		return wordsList;	
	}	
}