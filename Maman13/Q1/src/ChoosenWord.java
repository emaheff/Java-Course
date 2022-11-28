import java.util.List;

import javax.swing.JOptionPane;

public class ChoosenWord implements Updateable{
	
	private List<String> words = FileManagement.getWordsFromFile();
	
	public String getInitWordToPrint(String word) {
		String str = "";
		for(int i = 0; i < word.length(); i++) {
			str += "_ ";
		}
		return str;
	}
	
	public String getRandomWord() {
		return words.get(getRandomElement());
	}
	
	private int getRandomElement() {
    	return (int)(Math.random() * words.size());
    }
	
	
	public void update(State state){
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
		
		boolean isUnderLine = false;
		for(int i = 0; i < state.getWordToPrint().length(); i++) {
			if(state.getWordToPrint().charAt(i) == '_') {
				isUnderLine = true;
			}
		}
		if(!isUnderLine) {
			JOptionPane.showMessageDialog(null, "Well done! You guessed correctly the word\nthe word is: " + state.getChoosenWord());
			System.exit(0); // finish the program
		}
	}
	
	private String setLetterInWordToPrint(char letter, int i, String wordToPrint) {
		i += i; 
		wordToPrint = wordToPrint.substring(0, i) + letter + wordToPrint.substring(i+1);
		return wordToPrint;
	}
	
}

//StringBuilder choosenWord = new StringBuilder("");
//for(int i = 0; i < word.length(); i++) {
//	choosenWord.setCharAt(i, '_');
//}
//return choosenWord.toString();


//choosenWord.setCharAt(i, state.getLetter().charAt(0));
//state.setWordToPrint(choosenWord);