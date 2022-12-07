import java.util.List;


public class ChosenWord {

	// create a list with all words from the file
	private List<String> words = FileReader.getWordsFromFile();

	// create a string with '_' instead of the letters
	public String getStringWithUnderLines(String word) {
		String str = "";
		for(int i = 0; i < word.length(); i++) {
			str += "_ ";
		}
		return str;
	}

	// get a random word from the list (the list contains strings from the file)
	public String getRandomWord() {
		int index = getRandomIndex();		
		return words.remove(index);
	}

	// get a random index in the range of the list of words
	private int getRandomIndex() {
		return (int)(Math.random() * words.size());
	}

	public boolean isLetterInWord(char letter, String chosenWord) {
		for(int i = 0; i < chosenWord.length(); i++) {
			if(letter == chosenWord.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	// checks if there are any '_' in the string that indicate the user
	public boolean isUnderLine(String indicationString) {
		for(int i = 0; i < indicationString.length(); i++) {
			if(indicationString.charAt(i) == '_') {
				return true;
			}
		}
		return false;
	}

	// the method set the given char in the given string at the index place
	public String indicationWordToDisplay(char letter, String wordToPrint, String chosenWord) {
		int index;
		for(int i = 0; i < chosenWord.length(); i++) {
			index = i;
			if(letter == chosenWord.charAt(i)) {
				index += index;
				wordToPrint = wordToPrint.substring(0, index) + letter + wordToPrint.substring(index+1);
			}
		}
		return wordToPrint;
	}	
}