import java.util.List;


public class ChosenWord {
	
	// create a list with all words from the file
	private List<String> words = FileManagement.getWordsFromFile();
	
	// create a string with '_' instead of the letters
	public String getInitWordToPrint(String word) {
		String str = "";
		for(int i = 0; i < word.length(); i++) {
			str += "_ ";
		}
		return str;
	}
	
	// get a random word from the list (the list contains strings from the file)
	public String getRandomWord() {
		int i = getRandomElement();
		String randomWord = words.get(i);
		words.remove(i);
		return randomWord;
	}
	
	// get a random index from in the range of the list of words
	private int getRandomElement() {
    	return (int)(Math.random() * words.size());
    }
	
	// checks if the chosen (random) word contain the letter that the user choose   
	public void update(State state){
		boolean isCorrectLetter = false;
		for(int i = 0; i < state.getChosenWord().length(); i++) {
			if((state.getInputLetter().charAt(0)) == (state.getChosenWord().charAt(i))) {
				isCorrectLetter = true;
				// update the string that indicate the user.
				state.setIndicationString(indicationStringToShow(state.getInputLetter().charAt(0), i, state.getIndicationString()));
			}
		}
		// adds a mistake to the counter
		if(!isCorrectLetter) {
			state.setMistakes(state.getMistakes()+1);
		}
	}
	
	// checks if there are any '_' in the string that indicate the user
	public boolean isUnderLine(State state) {
		boolean isUnderLine = false;
		for(int i = 0; i < state.getIndicationString().length(); i++) {
			if(state.getIndicationString().charAt(i) == '_') {
				isUnderLine = true;
			}
		}
		return isUnderLine;
	}
	
	// the method set the given char in the given string at the index place
	private String indicationStringToShow(char letter, int i, String wordToPrint) {
		i += i; 
		wordToPrint = wordToPrint.substring(0, i) + letter + wordToPrint.substring(i+1);
		return wordToPrint;
	}	
}