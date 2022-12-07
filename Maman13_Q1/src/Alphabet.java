import java.util.ArrayList;
import java.util.List;

public class Alphabet {
	
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
		
    	alphabet.add('a');
    	alphabet.add('b');
    	alphabet.add('c');
    	alphabet.add('d');
    	alphabet.add('e');
    	alphabet.add('f');
    	alphabet.add('g');
    	alphabet.add('h');
    	alphabet.add('i');
    	alphabet.add('j');
    	alphabet.add('k');
    	alphabet.add('l');
    	alphabet.add('m');
    	alphabet.add('n');
    	alphabet.add('o');
    	alphabet.add('p');
    	alphabet.add('q');
    	alphabet.add('r');
    	alphabet.add('s');
    	alphabet.add('t');
    	alphabet.add('u');
    	alphabet.add('v');
    	alphabet.add('w');
    	alphabet.add('x');
    	alphabet.add('y');
    	alphabet.add('z');
    	return alphabet;
    }

	public List<Character> getCurrentAlphabet() {
		return alphabet;
	}
}
