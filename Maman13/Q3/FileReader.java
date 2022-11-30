package Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	// the method get the words from the file and contains the words in a list
		public List<String> getAllLines() {
			List<String> lines = new ArrayList<>();
			try {
				Scanner scan = new Scanner(new File("C:\\Users\\DELL\\code\\java\\Maman13\\Q1\\src\\hangManFile.txt"));
				while(scan.hasNext()) {
					lines.add(scan.next());
				}
				scan.close();
			} catch (FileNotFoundException e) {
				System.out.println("Problam with opening the file");
			}
			return lines;	
		}	
}


