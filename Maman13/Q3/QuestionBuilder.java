package Q2;

import java.util.ArrayList;
import java.util.List;

public class QuestionBuilder {
	
	private static final int QUESTION_PARTITION_SIZE = 5;
	private List<String> lines;
	
	
	public QuestionBuilder (List<String> lines) {
		this.lines = lines;
	}
	
	public List<Question> getAllQuestions(){
		List<List<String>> questionPartitions = getQuestionPartitions();
		List<Question> questions = new ArrayList<>(); 

		    for (List<String> questionPartition : questionPartitions) {
		    	String q = questionPartition.get(0);
		    	String correctAnswer = questionPartition.get(1);
		    	String ans2 = questionPartition.get(2);
		    	String ans3 = questionPartition.get(3);
		    	String ans4 = questionPartition.get(4);
		    	Question question = new Question(q, correctAnswer, ans2, ans3, ans4);
		    	questions.add(question);
		    }
		 return questions;
	}
	
	private List<List<String>> getQuestionPartitions(){
		 List<List<String>> questionPartitions = new ArrayList<>();

		    for (int i=0; i<lines.size(); i +=  QUESTION_PARTITION_SIZE) {
		    	questionPartitions.add(lines.subList(i, Math.min(i +  QUESTION_PARTITION_SIZE, lines.size())));
		    }
		    return questionPartitions;
	}
}
