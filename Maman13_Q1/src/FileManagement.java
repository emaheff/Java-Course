import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagement {
	
	// the method get the words from the file and contains the words in a list
	public static List<String> getWordsFromFile() {
		List<String> wordList = new ArrayList<>();
		try {
			Scanner scan = new Scanner(new File("C:\\Users\\DELL\\code\\java\\Maman13_Q1\\src\\hangManFile.txt"));
			while(scan.hasNext()) {
				wordList.add(scan.next());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problam with opening the file");
		}
		return wordList;	
	}	
}