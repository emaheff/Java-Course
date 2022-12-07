import java.util.List;
import java.util.Optional;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;

public class TriviaController {

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Label qLabel;

    @FXML
    private Label scoreLabel;
    
    private TriviaSession session = new TriviaSession();
    private Font font = new Font("Ariel", 24);
    private Alert alert = new Alert(AlertType.INFORMATION);
	private ButtonType buttonTypeYes = new ButtonType("Yes");
	private ButtonType buttonTypeNo = new ButtonType("No");
	private ButtonType buttonTypeOK = new ButtonType("OK");
	
    @FXML
    void exitBtn(ActionEvent event) {
    	displayScore();
    	System.exit(0);
    }

    @FXML
    void okBtn(ActionEvent event) {
    	String userInput = combo.getValue();
    	combo.getItems().removeAll(combo.getItems()); // delete the comboBox option
    	session.addUserAnswer(userInput); 
    	scoreLabel.setText("" + session.getScore()); // display the score of the game
    	if(!session.hasMoreQuestions()) { 
    		alert.getButtonTypes().clear();
    		alert.setTitle("No more questions");
    		alert.setContentText("Your final score is " + session.getScore() +"\nDo you want to play again?");
    		alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
    		Optional<ButtonType> result = alert.showAndWait();
    		if(result.get() == buttonTypeYes) {
    			initialize();	    	
    		}else {
    		System.exit(0);
    		}
    	}
    	displayQuestion();
    }

    @FXML
    void playAgainBtn(ActionEvent event) {
    	displayScore();
    	initialize();
    }
    
    private void displayScore() {
    	alert.getButtonTypes().clear();
		alert.getButtonTypes().setAll(buttonTypeOK);
		alert.setHeaderText(null);
		alert.setTitle(null);
		alert.setContentText("Your final score is " + session.getScore());
		alert.showAndWait();
    }
    
    public void initialize() {
    	session = new TriviaSession(); // new gameSession in case its not the first game
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