import java.util.List;
import javafx.scene.canvas.GraphicsContext;


public class ChoosenWord {// implements Updateable{
	
	private List<String> words = FileManagement.getWordsFromFile();
	
	public String getInitWordToPrint(String word) {
		String str = "";
		for(int i = 0; i < word.length(); i++) {
			str += "_ ";
		}
		return str;
	}
	
	public String getRandomWord() {
		int i = getRandomElement();
		String randomWord = words.get(i);
		words.remove(i);
		return randomWord;
	}
	
	private int getRandomElement() {
    	return (int)(Math.random() * words.size());
    }
	
	
	public void update(State state, GraphicsContext gc, double canvWidth, double canvHeigth){
		boolean isCorrectLetter = false;
		for(int i = 0; i < state.getChoosenWord().length(); i++) {
			if((state.getLetter().charAt(0)) == (state.getChoosenWord().charAt(i))) {
				isCorrectLetter = true;
				state.setWordToPrint(setLetterInWordToPrint(state.getLetter().charAt(0), i, state.getWordToPrint()));
			}
		}
		if(!isCorrectLetter) {
			state.setMistakes(state.getMistakes()+1);
		}
	}
	
	public boolean isUnderLine(State state) {
		boolean isUnderLine = false;
		for(int i = 0; i < state.getWordToPrint().length(); i++) {
			if(state.getWordToPrint().charAt(i) == '_') {
				isUnderLine = true;
			}
		}
		return isUnderLine;
	}
	
	private String setLetterInWordToPrint(char letter, int i, String wordToPrint) {
		i += i; 
		wordToPrint = wordToPrint.substring(0, i) + letter + wordToPrint.substring(i+1);
		return wordToPrint;
	}
	
}

//int ans = JOptionPane.showConfirmDialog(null, "Well done!\nThe word is: " + state.getChoosenWord() + "\nDo you want to play again?");
//if(ans == 0) {
//	state.setMistakes(0);
//	state.setChoosenWord(getRandomWord());
//	state.setUsedLetters("");
//	state.setWordToPrint(getInitWordToPrint(state.getChoosenWord()));
//	gc.clearRect(0, 0, canvWidth, canvHeigth);
//	alphabet.getFullListLetters();
//	lettersCombo.getItems().removeAll(lettersCombo.getItems());
//	ac.showCombo(alphabet.getAlphabet());
//	
//}else {
//	System.exit(0); // finish the program
//}