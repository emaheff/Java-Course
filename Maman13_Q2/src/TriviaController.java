import java.util.List;

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
    
    GameSession session = new GameSession();
	
	

    @FXML
    void exitBtn(ActionEvent event) {
    	// pop-up with the score
    	System.exit(0);
    }

    @FXML
    void okBtn(ActionEvent event) {
    	String userInput = combo.getValue();
    	scoreLabel.setFont(new Font("Ariel", 24));
    	combo.getItems().removeAll(combo.getItems());
    	session.addUserAnswer(userInput); 
    	scoreLabel.setText("" + session.getScore());
    	if(!session.hasMoreQuestions()) { 
    		System.exit(0);
    	}
    	displayQuestion();
    }

    @FXML
    void playAgainBtn(ActionEvent event) {
    	session = new GameSession();
    	initialize();
    }
    
    public void initialize() {
    	
    	qLabel.setFont(new Font("Ariel", 24));
    	scoreLabel.setText("" + session.getScore());
    	displayQuestion();
    }
    
    private void displayQuestion() {
    	String q = session.getNextQuestion(); 
    	qLabel.setText(q);
    	List<String> answers = session.getChoices(); 
    	for(String ans: answers) {
    		combo.getItems().add(ans);
    	}
    }
    
}