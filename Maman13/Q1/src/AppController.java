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
    private ChoosenWord choosenWord = new ChoosenWord();
    private HangMan hangMan = new HangMan();
    private final int MAX_MISTAKES = 10;
    
    
    @FXML
    void okBtnPressed(ActionEvent event) {
    	updateMove();
    	if(state.getMistakes() == MAX_MISTAKES) {
    		 int ans = JOptionPane.showConfirmDialog(null, "Game over!\nThe word was: " + 
    				 state.getChoosenWord() + "\nDo you want to play again?", "Yow lose!",JOptionPane.YES_NO_OPTION);
    		 if(ans == 0) {
    			 resetData();
    		 }else {
    			 System.exit(0); // finish the program
    		 }
    	}else if(!choosenWord.isUnderLine(state)) {
    		int ans = JOptionPane.showConfirmDialog(null, "Well done!\nThe word was: " + 
   				 state.getChoosenWord() + "\nDo you want to play again?", "Yow wone!",JOptionPane.YES_NO_OPTION);
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
	
	private void updateMove() {
		
		// update the current letter from user
    	state.setLetter(lettersCombo.getValue()); 
    	
    	// update the used letters and shows it on the UI
    	state.setUsedLetters(state.getUsedLetters() + state.getLetter() +" "); 
    	usedLetters.setText(state.getUsedLetters()); 
    	
    	// update the word that shows on the UI (the missing letters word (for example - "_ _ a _ v"))
    	choosenWord.update(state, gc, canv.getWidth(), canv.getHeight());
    	word.setText(state.getWordToPrint());
    	
    	// update the draw according to the amount of the mistakes
    	gc = canv.getGraphicsContext2D();
    	hangMan.update(state, gc, canv.getWidth(), canv.getHeight());
    	
    	// update the alphabet - delete used letters from the alphabet and update the comboBox
    	alphabet.update(state);
    	lettersCombo.getItems().removeAll(lettersCombo.getItems());
     	showCombo(alphabet.getAlphabet());
	}
	
	private void resetData() {
		
		
		gc = canv.getGraphicsContext2D();
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
		
		state.setMistakes(0);
		
		// get a random word from the file
    	state.setChoosenWord(choosenWord.getRandomWord());
    	
    	state.setWordToPrint(choosenWord.getInitWordToPrint(state.getChoosenWord()));
    	word.setText(state.getWordToPrint());
    	
    	state.setUsedLetters("");
    	usedLetters.setText(state.getUsedLetters());
    	
    	// initialize the comboBox to be the full alphabet
    	alphabet.getFullListLetters();
    	lettersCombo.getItems().removeAll(lettersCombo.getItems());
    	showCombo(alphabet.getAlphabet());
	}
	
}