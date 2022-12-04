import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TriviaController {
	
	private int scoreCnt = 0;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Label qLabel;

    @FXML
    private Label scoreLabel;
    
    FileReader fr = new FileReader(); // can the getAllLines() be a static method?
	List<String> lines = fr.getAllLines();
	QuestionBuilder qb = new QuestionBuilder(lines);
	List<Question> questions = qb.getAllQuestions();
	ShuffleIterator<Question> it = new ShuffleIterator<Question>(questions);
	Question question = it.next();
	String q = question.getQ();
	List<String> answers = question.getAnswers();
	ShuffleIterator<String> it2 = new ShuffleIterator<String>(answers);
	
	

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
    	if(userInput.equals(question.getA())) {
    		scoreCnt += 10;
    		scoreLabel.setText("" + scoreCnt);
    		if(it.hasNext()) {
    			question = it.next();
    			String q = question.getQ();
    			qLabel.setText(q);
    			answers = question.getAnswers();
    			ShuffleIterator<String> it2 = new ShuffleIterator<String>(answers);
    			while(it2.hasNext()) {
    	    		String choice = it2.next();
    	    		combo.getItems().add(choice);
    	    	}
    			
    		}else {
    			// no more questions your score:
    			System.exit(0);
    		}
    	}else {
    		scoreCnt -= 5;
    		scoreLabel.setText("" + scoreCnt);
    		if(it.hasNext()) {
    			question = it.next();
    			String q = question.getQ();
    			qLabel.setText(q);
    			answers = question.getAnswers();
    			ShuffleIterator<String> it2 = new ShuffleIterator<String>(answers);
    			while(it2.hasNext()) {
    	    		String choice = it2.next();
    	    		combo.getItems().add(choice);
    	    	}
    			
    		}
    	}
    }

    @FXML
    void playAgainBtn(ActionEvent event) {
    	
    	
    }
    
    public void initialize() {
    	
    	qLabel.setFont(new Font("Ariel", 24));
    	qLabel.setText(q);
    		
    	while(it2.hasNext()) {
    		String choice = it2.next();
    		combo.getItems().add(choice);
    	}
    }
    
}