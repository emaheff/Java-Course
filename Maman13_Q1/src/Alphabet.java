import java.util.ArrayList;
import java.util.List;

public class Alphabet {
	
	private List<Character> alphabet = new ArrayList<>();
	

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
		for(char letter = 'a'; letter <= 'z'; letter++) { 
			alphabet.add(letter);
		}
    	return alphabet;
    }

	public List<Character> getCurrentAlphabet() {
		return alphabet;
	}
}
