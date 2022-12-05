import java.util.List;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TriviaController {

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Label qLabel;

    @FXML
    private Label scoreLabel;
    
    private GameSession session = new GameSession();
    private Font font = new Font("Ariel", 24);
	
    @FXML
    void exitBtn(ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "Your final score: " + session.getScore());
    	System.exit(0);
    }

    @FXML
    void okBtn(ActionEvent event) {
    	String userInput = combo.getValue();
    	combo.getItems().removeAll(combo.getItems()); // delete the comboBox option
    	session.addUserAnswer(userInput); 
    	scoreLabel.setText("" + session.getScore()); // display the score of the game
    	if(!session.hasMoreQuestions()) { 
    		int ans = JOptionPane.showConfirmDialog(null, "No more questions.\nYour final score: " + session.getScore() +
                    "\nDo you want to play again?", "No more questions",JOptionPane.YES_NO_OPTION);
    		if(ans == 0) { // the user pressed on "Yes" button - start a new game
    	    	initialize();
    		}else {
    		System.exit(0);
    		}
    	}
    	displayQuestion();
    }

    @FXML
    void playAgainBtn(ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "Your final score: " + session.getScore());
    	initialize();
    }
    
    public void initialize() {
    	session = new GameSession(); // new gameSession in case its not the first game
    	qLabel.setFont(font);
    	scoreLabel.setFont(font);
    	displayQuestion();
    }
    
    private void displayQuestion() {
    	combo.getItems().removeAll(combo.getItems()); // remove items from combo in case its not the first question
    	scoreLabel.setText("" + session.getScore());
    	String q = session.getNextQuestion(); 
    	qLabel.setText(q);
    	List<String> answers = session.getChoices(); 
    	for(String ans: answers) {
    		combo.getItems().add(ans);
    	}
    	combo.setValue(answers.get(0));
    }
}