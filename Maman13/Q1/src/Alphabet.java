import java.util.ArrayList;
import java.util.List;

public class Alphabet implements Updateable{
	
	private List<String> alphabet = new ArrayList<>();
	
	public Alphabet(List<String> alphabet) {
		this.alphabet = alphabet;
	}

	
	public void update(State state) {
		for(int i = 0; i < alphabet.size(); i++) {
    		if(alphabet.get(i).charAt(0) == state.getLetter().charAt(0)) {
    			alphabet.remove(i);
    			break;
    		}
    	}
	}
	
	public List<String> getFullListLetters() {
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
