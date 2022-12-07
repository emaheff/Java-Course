import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class AppController {

	@FXML
	private Canvas canv;

	@FXML
	private ComboBox<Character> lettersCombo;

	@FXML
	private Label usedLettersLabel;

	@FXML
	private Label wordLabel;

	private GraphicsContext gc;
	private List<Character> list = new ArrayList<>();
	private Alphabet alphabet = new Alphabet(list);
	private State state = new State();
	private ChosenWord chosenWord = new ChosenWord();
	private HangMan hangMan = new HangMan();
	private Alert alert = new Alert(AlertType.INFORMATION);
	private ButtonType buttonTypeYes = new ButtonType("Yes");
	private ButtonType buttonTypeNo = new ButtonType("No");
	private ButtonType buttonTypeOK = new ButtonType("OK");
	
	
	private static final int MAX_MISTAKES = 10;
	private Font font = new Font("Ariel", 24);


	@FXML
	void okBtnPressed(ActionEvent event) {
		updateSession();
		displaySession();
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
		alert.getButtonTypes().clear();
		alert.getButtonTypes().setAll(buttonTypeOK);
		alert.setHeaderText(null);
		if(state.getMistakes() == MAX_MISTAKES) {
			alert.setTitle("Game Over!");
			alert.setContentText("You lost!\nThe word was " + state.getChosenWord());
			alert.showAndWait();
			return true;
		}else if(!chosenWord.isUnderLine(state.getIndicationString())) { // the user guessed the word
			alert.setTitle("Well Done!");
			alert.setContentText("You won!\nThe word is " + state.getChosenWord());
			alert.showAndWait();
			return true;
		}
		return false;
	}

	private boolean isNewGame() {
		alert.getButtonTypes().clear();
		alert.setTitle("Play Again?");
		alert.setContentText("Do you want to play again?");
		alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == buttonTypeYes) {	
			return true;
		}
		return false;
	}

	// the method updates the required steps
	private void updateSession() {
		String currentWord = state.getChosenWord();

		// update the input letter from the user
		char inputLetter = lettersCombo.getValue();
		state.setInputLetter(inputLetter); 

		// update the used letters 
		String usedLetters = state.getUsedLetters();
		state.setUsedLetters(usedLetters + inputLetter +" "); 

		// update the string that shows on the UI (the missing letters word (for example - "_ _ a _ v"))
		if(chosenWord.isLetterInWord(inputLetter, currentWord)) {
			String indicationWord = chosenWord.indicationWordToDisplay(inputLetter, state.getIndicationString(), currentWord);
			state.setIndicationString(indicationWord);
		}else { // update the mistakes counter
			int currentMistakes = state.getMistakes();
			state.setMistakes(currentMistakes + 1);
		}

		// update the alphabet - delete used letter from the alphabet
		alphabet.updateAlphabet(inputLetter);
	}

	// the method display the data on the UI
	private void displaySession() {
		String indicationString = state.getIndicationString();
		wordLabel.setText(indicationString);

		String usedLetters = state.getUsedLetters();
		usedLettersLabel.setText(usedLetters);

		hangMan.draw(state.getMistakes(), gc, canv.getWidth(), canv.getHeight());

		lettersCombo.getItems().removeAll(lettersCombo.getItems());
		showCombo();
	}

	// the method reset the required fields
	private void newGame() {

		// clears the canvas in case the user wants to play again
		gc = canv.getGraphicsContext2D();
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());

		state.setMistakes(0);

		// get a random word from the list of words and set it on the right field of State
		String currentWord = chosenWord.getRandomWord();
		state.setChosenWord(currentWord);
		
		// make a string with '_' instead of the letters in the chosen word and set it on the right field of State
		String StringWithUnderLines = chosenWord.getStringWithUnderLines(currentWord);
		state.setIndicationString(StringWithUnderLines);

		// clears the used letters string in case its not empty (the user wants to play again)
		state.setUsedLetters("");

		// initialize the comboBox to be the full alphabet
		alphabet.getFullAlphabet();
	}
	
	private void showCombo() {
		List<Character> correntAlphabet =  alphabet.getCurrentAlphabet();
		for(Character letter: correntAlphabet) {			
			lettersCombo.getItems().add(letter);
		}
		lettersCombo.setValue(correntAlphabet.get(0));
	}
}