
public class State {
	
	private String choosenWord;
	private String usedLetters = "";
	private String letter;
	private String wordToPrint;
	private int mistakes;
	
//	public State(String choosenWord, String usedLetters, String letter, int hangMan) {
//		this.choosenWord = choosenWord;
//		this.usedLetters = usedLetters;
//		this.letter = letter;
//		this.hangMan = hangMan;
//	}

	public String getChoosenWord() {
		return choosenWord;
	}

	public void setChoosenWord(String choosenWord) {
		this.choosenWord = choosenWord;
	}

	public String getUsedLetters() {
		return usedLetters;
	}

	public void setUsedLetters(String usedLetters) {
		this.usedLetters = usedLetters;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public int getMistakes() {
		return mistakes;
	}

	public void setMistakes(int hangMan) {
		this.mistakes = hangMan;
	}

	public String getWordToPrint() {
		return wordToPrint;
	}

	public void setWordToPrint(String wordToPrint) {
		this.wordToPrint = wordToPrint;
	}
}
