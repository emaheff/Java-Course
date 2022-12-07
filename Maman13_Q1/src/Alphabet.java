import java.util.ArrayList;
import java.util.List;

public class Alphabet {
	
	private static final int NUMBER_OF_LETTERS = 26;
	private List<Character> alphabet = new ArrayList<>();
	
	// a builder. do i need a builder?
	public Alphabet(List<Character> alphabet) {
		this.alphabet = alphabet;
	}

	// the method remove from the alphabet the letter that the user choose
	public void updateAlphabet(char letter) {
		for(int i = 0; i < alphabet.size(); i++) {
			if(alphabet.get(i) == letter) {
    			alphabet.remove(i);
    			break;
    		}
    	}
	}
	
	// the name of the method speak by itself
	public List<Character> getFullAlphabet() {
		// clears the list in case the user wants to play again and there are letters that remains
		alphabet.clear();
		for(int i = 0; i < NUMBER_OF_LETTERS; i++) {
			char letter = (char)(i + 97); // a is 97 in ASCII 
			alphabet.add(letter);
		}
    	return alphabet;
    }

	public List<Character> getCurrentAlphabet() {
		return alphabet;
	}
}
