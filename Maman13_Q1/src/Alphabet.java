import java.util.ArrayList;
import java.util.List;

public class Alphabet {
	
	private List<String> alphabet = new ArrayList<>();
	
	public Alphabet(List<String> alphabet) {
		this.alphabet = alphabet;
	}

	// the method remove from the alphabet the letter that the user choose
	public void update(State state) {
		for(int i = 0; i < alphabet.size(); i++) {
    		if(alphabet.get(i).charAt(0) == state.getInputLetter().charAt(0)) {
    			alphabet.remove(i);
    			break;
    		}
    	}
	}
	
	// the name of the method speak by itself
	public List<String> getFullAlphabet() {
		// clears the list in case the user wants to play again and there are letters that remains
		alphabet.clear();
		
    	alphabet.add("a");
    	alphabet.add("b");
    	alphabet.add("c");
    	alphabet.add("d");
    	alphabet.add("e");
    	alphabet.add("f");
    	alphabet.add("g");
    	alphabet.add("h");
    	alphabet.add("i");
    	alphabet.add("j");
    	alphabet.add("k");
    	alphabet.add("l");
    	alphabet.add("m");
    	alphabet.add("n");
    	alphabet.add("o");
    	alphabet.add("p");
    	alphabet.add("q");
    	alphabet.add("r");
    	alphabet.add("s");
    	alphabet.add("t");
    	alphabet.add("u");
    	alphabet.add("v");
    	alphabet.add("w");
    	alphabet.add("x");
    	alphabet.add("y");
    	alphabet.add("z");
    	return alphabet;
    }

	public List<String> getAlphabet() {
		return alphabet;
	}
}
