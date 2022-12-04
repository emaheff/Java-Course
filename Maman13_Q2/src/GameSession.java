import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameSession {
	
	private Iterator<Question> questionsIterator;
	private Question question;
	private int score;
	
	public GameSession() {
		FileReader fr = new FileReader(); // can the getAllLines() be a static method?
		List<String> lines = fr.getAllLines();
		QuestionBuilder qb = new QuestionBuilder(lines);
		List<Question> questions = qb.getAllQuestions();
		this.questionsIterator = new ShuffleIterator<Question>(questions);
	}
	
	public void addUserAnswer(String userInput) {
		String correctAns = question.getA();
		score += correctAns.equals(userInput) ? 10 :-5;
		
	}

	public int getScore() {
		return score;
	}
	
	public boolean hasMoreQuestions() {
		return questionsIterator.hasNext();
	}
	
	public String getNextQuestion() {
		question = questionsIterator.next();
		return question.getQ();
	}
	
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
