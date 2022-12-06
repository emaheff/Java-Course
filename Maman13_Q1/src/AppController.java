import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class AppController {

	@FXML
	private Canvas canv;

	@FXML
	private ComboBox<String> lettersCombo;

	@FXML
	private Label usedLettersLabel;

	@FXML
	private Label wordLabel;

	private GraphicsContext gc;
	private List<String> list = new ArrayList<>();
	private Alphabet alphabet = new Alphabet(list);
	private State state = new State();
	private ChosenWord chosenWord = new ChosenWord();
	private HangMan hangMan = new HangMan();
	private static final int MAX_MISTAKES = 10;
	private Font font = new Font("Ariel", 24);


	@FXML
	void okBtnPressed(ActionEvent event) {
		updateSession();
		displaySession();
//		System.out.println("yoohoo");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		if(isGameOver()) {
			if(isNewGame()) {
				initialize();
			}else {
				System.exit(0);
			}
		}
	}

	public void initialize() {
		wordLabel.setFont(font);
		usedLettersLabel.setFont(font);
		newGame();
		displaySession();

	}

	private boolean isGameOver() {
		if(state.getMistakes() == MAX_MISTAKES) {
			JOptionPane.showMessageDialog(null, "Game over!\nThe word was: " + state.getChosenWord());
			return true;
		}else if(!chosenWord.isUnderLine(state)) { // the user guessed the word
			JOptionPane.showMessageDialog(null, "Well Done!\nYou guessed the word: " + state.getChosenWord() 
			+ " correctly!");
			return true;
		}
		return false;
	}

	private boolean isNewGame() {
		int ans = JOptionPane.showConfirmDialog(null, "Do you want to play again?", null ,JOptionPane.YES_NO_OPTION);
		if(ans == 0) {
			return true;
		}
		return false;
	}

	private void showCombo() {
		List<String> correntAlphabet =  alphabet.getAlphabet();
		for(String letter: correntAlphabet) {
			lettersCombo.getItems().add(letter);
		}
		lettersCombo.setValue(correntAlphabet.get(0));
	}

	// the method updates the required steps
	private void updateSession() {

		// update the input letter from the user
		String inputLetter = lettersCombo.getValue();
		state.setInputLetter(inputLetter); 

		// update the used letters 
		String usedLetters = state.getUsedLetters();
		state.setUsedLetters(usedLetters + inputLetter +" "); 

		// update the string that shows on the UI (the missing letters word (for example - "_ _ a _ v"))
		chosenWord.update(state);

		// update the draw according to the amount of the mistakes
		if(!chosenWord.isCorrectLetter(state)) {
			int currentMistakes = state.getMistakes();
			state.setMistakes(currentMistakes + 1);
		}

		// update the alphabet - delete used letters from the alphabet and update the comboBox
		alphabet.update(state);
	}

	// the method display the data on the UI
	private void displaySession() {
		String indicationString = state.getIndicationString();
		wordLabel.setText(indicationString);

		String usedLetters = state.getUsedLetters();
		usedLettersLabel.setText(usedLetters);

		hangMan.update(state, gc, canv.getWidth(), canv.getHeight());

		lettersCombo.getItems().removeAll(lettersCombo.getItems());
		showCombo();
	}

	// the method reset the required fields
	private void newGame() {

		// clears the canvas in case the user wants to play again
		gc = canv.getGraphicsContext2D();
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());

		state.setMistakes(0);

		// get a random word from the file and set it in the right field of State
		String randomWord = chosenWord.getRandomWord();
		state.setChosenWord(randomWord);

		// set the indication string and shows it on the UI  
		String currentWord = state.getChosenWord();
		String StringWithUnderLines = chosenWord.getStringWithUnderLines(currentWord);
		state.setIndicationString(StringWithUnderLines);

		// clears the used letters string in case its not empty (the user wants to play again)
		state.setUsedLetters("");

		// initialize the comboBox to be the full alphabet
		alphabet.getFullAlphabet();
	}
}