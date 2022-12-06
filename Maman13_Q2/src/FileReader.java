import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	// the method get the lines from the file and contain the lines in a list
		public  List<String> getAllLines() {
			List<String> lines = new ArrayList<>();
			try {
				Scanner scan = new Scanner(new File("TriviaQuestionsJava.txt")); // if you want a tester use - "TriviaQuestionsJavaTester.txt"
				while(scan.hasNext()) {
					lines.add(scan.nextLine());
				}
				scan.close();
			} catch (FileNotFoundException e) {
				System.out.println("Problem with opening the file");
			}
			return lines;	
		}	
}