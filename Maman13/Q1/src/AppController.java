import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class AppController {

    @FXML
    private Canvas canv;

    @FXML
    private ComboBox<String> lettersCombo;

    @FXML
    private Label usedLetters;

    @FXML
    private Label word;
    private GraphicsContext gc;
    private List<String> list = new ArrayList<>();
    private Alphabet alphabet = new Alphabet(list);
    private State state = new State();
    private ChosenWord chosenWord = new ChosenWord();
    private HangMan hangMan = new HangMan();
    private final int MAX_MISTAKES = 10;
    
    
    @FXML
    void okBtnPressed(ActionEvent event) {
    	updateStep();
    	if(state.getMistakes() == MAX_MISTAKES) {
    		 int ans = JOptionPane.showConfirmDialog(null, "Game over!\nThe word was: " + 
    				 state.getChosenWord() + "\nDo you want to play again?", "Yow lose!",JOptionPane.YES_NO_OPTION);
    		 if(ans == 0) {
    			 resetData();
    		 }else {
    			 System.exit(0); // finish the program
    		 }
    	}else if(!chosenWord.isUnderLine(state)) {
    		int ans = JOptionPane.showConfirmDialog(null, "Well done!\nThe word was: " + 
   				 state.getChosenWord() + "\nDo you want to play again?", "Yow won!",JOptionPane.YES_NO_OPTION);
    		if(ans == 0) {
    			resetData();
   		 	}else {
   			 System.exit(0); // finish the program
   		 	}
    	}
    }
    
    public void initialize() {
    	resetData();
    }
    
	private void showCombo(List<String> updateAlphabet) {
		for(int i = 0; i < updateAlphabet.size(); i++) {
			lettersCombo.getItems().add(updateAlphabet.get(i));
		}
		lettersCombo.setValue(updateAlphabet.get(0));
    }
	
	// the method updates the required steps and shows it on the UI
	private void updateStep() {
		
		// update the input letter from the user
    	state.setInputLetter(lettersCombo.getValue()); 
    	
    	// update the used letters and shows it on the UI
    	state.setUsedLetters(state.getUsedLetters() + state.getInputLetter() +" "); 
    	usedLetters.setText(state.getUsedLetters()); 
    	
    	// update the string that shows on the UI (the missing letters word (for example - "_ _ a _ v"))
    	// if needs and shows the result. in addition update the mistake counter if needs.
    	chosenWord.update(state);
    	word.setText(state.getIndicationString());
    	
    	// update the draw according to the amount of the mistakes
    	hangMan.update(state, gc, canv.getWidth(), canv.getHeight());
    	
    	// update the alphabet - delete used letters from the alphabet and update the comboBox
    	alphabet.update(state);
    	lettersCombo.getItems().removeAll(lettersCombo.getItems());
     	showCombo(alphabet.getAlphabet());
	}
	
	// the method reset the required steps and shows it on the UI
	private void resetData() {
		
		// clears the canvas in case the user wants to play again
		gc = canv.getGraphicsContext2D();
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
		
		state.setMistakes(0);
		
		// get a random word from the file and set it in the right field of State
    	state.setChosenWord(chosenWord.getRandomWord());
    	
    	// set the indication string and shows it on the UI  
    	state.setIndicationString(chosenWord.getInitWordToPrint(state.getChosenWord()));
    	word.setText(state.getIndicationString());
    	
    	// clears the used letters string in case its not empty (the user wants to play again)
    	state.setUsedLetters("");
    	usedLetters.setText(state.getUsedLetters());
    	
    	// initialize the comboBox to be the full alphabet
    	alphabet.getFullAlphabet();
    	lettersCombo.getItems().removeAll(lettersCombo.getItems());
    	showCombo(alphabet.getAlphabet());
	}
}