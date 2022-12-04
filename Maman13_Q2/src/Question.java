import java.util.ArrayList;
import java.util.List;

public class Question {
	private String q; 
	private String correctAns;
	private List<String> answers;
	
	public Question(String q, String correctAns, String ans2, String ans3, String ans4) {
		this.q = q;
		this.correctAns = correctAns;
		this.answers = new ArrayList<String>();
		this.answers.add(correctAns);
		this.answers.add(ans2);
		this.answers.add(ans3);
		this.answers.add(ans4);
	}
	
	public String getQ() {
		return q;
	}
	
	public String getA() {
		return correctAns;
	}
	
	public List<String> getAnswers() {	
		return answers;
	}

	@Override
	public String toString() {
		return "Question:\n q = " + q + "\ncorrectAns = " + correctAns + "\nanswers 2 = " + answers.get(0) +
				"\nanswer 3 = " + answers.get(1) + "\nanswer 4 = " + answers.get(2) ;
	}
	
	
}
