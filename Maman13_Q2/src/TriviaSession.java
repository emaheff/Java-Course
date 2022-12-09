import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class TriviaSession {
	
	private Iterator<Question> questionsIterator;
	private Question question;
	private int score;
	private Alert alert = new Alert(AlertType.INFORMATION);
	private ButtonType buttonTypeOK = new ButtonType("OK");
	
	public TriviaSession() {
		FileReader fr = new FileReader();
		List<String> lines = fr.getAllLines();
		QuestionBuilder qb = new QuestionBuilder(lines);
		List<Question> questions = qb.getAllQuestions();
		this.questionsIterator = new ShuffleIterator<Question>(questions);
	}
	
	// the method checks if the answer is correct and displays it to the user
	public void addUserAnswer(String userInput) {
		String correctAns = question.getA();
		alert.getButtonTypes().clear();
		alert.getButtonTypes().setAll(buttonTypeOK);
		alert.setHeaderText(null);
		alert.setTitle(null);
		if(correctAns.equals(userInput)) {
			score += 10;
			alert.setContentText("Correct answer!");
			alert.showAndWait();
		}else {
			score -= 5;
			alert.setContentText("Wrong answer!");
			alert.showAndWait();
		}
	}

	public int getScore() {
		return score;
	}
	
	// the method checks if there is more questions to the continue the game
	public boolean hasMoreQuestions() {
		return questionsIterator.hasNext();
	}
	
	// the method return the next question 
	public String getNextQuestion() {
		question = questionsIterator.next();
		return question.getQ();
	}
	
	// the method return a list of shuffled answers
	public List<String> getChoices(){
		List<String> answers = question.getAnswers();
		Iterator<String> it = new ShuffleIterator<String>(answers);
		List<String> choices = new ArrayList<>();
		while(it.hasNext()) {
			choices.add(it.next());
		}
		return choices;
	}
}