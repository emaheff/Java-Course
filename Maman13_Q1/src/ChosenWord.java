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
	
	// checks if the chosen (random) word contain the letter that the user choose   
	public void update(State state){
		char letterToCheck = state.getInputLetter().charAt(0);
		String currentWord = state.getChosenWord();
		for(int i = 0; i < state.getChosenWord().length(); i++) {
			if(letterToCheck == currentWord.charAt(i)) {
				// update the string that indicate the user.
				String wordToPrint = state.getIndicationString();
				char letter = state.getInputLetter().charAt(0);
				String indication = indicationStringToShow(letter, i, wordToPrint);
				state.setIndicationString(indication);
			}
		}
	}
	
	public boolean isCorrectLetter(State state) {
		char letterToCheck = state.getInputLetter().charAt(0);
		String currentWord = state.getChosenWord();
		for(int i = 0; i < currentWord.length(); i++) {
			if(letterToCheck  == currentWord.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	// checks if there are any '_' in the string that indicate the user
	public boolean isUnderLine(State state) {
		for(int i = 0; i < state.getIndicationString().length(); i++) {
			if(state.getIndicationString().charAt(i) == '_') {
				return true;
			}
		}
		return false;
	}
	
	// the method set the given char in the given string at the index place
	private String indicationStringToShow(char letter, int i, String wordToPrint) {
		i += i; 
		wordToPrint = wordToPrint.substring(0, i) + letter + wordToPrint.substring(i+1);
		return wordToPrint;
	}	
}