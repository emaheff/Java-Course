package Q2;

public class Question {
	private String q; 
	private String correctAns; 
	private ShuffleIterator<String> answersIterator;
	
	public Question(String q, String correctAns, ShuffleIterator<String> answersIterator) {
		this.q = q;
		this.correctAns = correctAns;
		this.answersIterator = answersIterator;
	}
	
	public String getQ() {
		return q;
	}
	
	public String getA() {
		return correctAns;
	}
	
	public ShuffleIterator<String> getAnswersIterator() {
		return answersIterator;
	}
}
