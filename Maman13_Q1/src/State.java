
public class State {
	
	private String chosenWord;
	private String usedLetters;
	private String indicationString;
	private int mistakes;

	public String getChosenWord() {
		return chosenWord;
	}

	public void setChosenWord(String chosenWord) {
		this.chosenWord = chosenWord;
	}

	public String getUsedLetters() {
		return usedLetters;
	}

	public void setUsedLetters(String usedLetters) {
		this.usedLetters = usedLetters;
	}


	public int getMistakes() {
		return mistakes;
	}

	public void setMistakes(int mistakes) {
		this.mistakes = mistakes;
	}

	public String getIndicationString() {
		return indicationString;
	}

	public void setIndicationString(String indicationString) {
		this.indicationString = indicationString;
	}
}
