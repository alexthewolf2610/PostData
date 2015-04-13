package addTestPostData;

import java.util.List;


public class Question {
	
	public Long id;
	public Long masterQuestion;
	public Long questionTypeID;

    public List<Answer> answers;
	public double mark;
	
	
	public Question(Long id, Long masterQuestion, Long questionTypeID, double mark) {
		super();
		this.id = id;
		this.masterQuestion = masterQuestion;
		this.questionTypeID = questionTypeID;
		this.mark = mark;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMasterQuestion() {
		return masterQuestion;
	}
	public void setMasterQuestion(Long masterQuestion) {
		this.masterQuestion = masterQuestion;
	}
	public Long getQuestionTypeID() {
		return questionTypeID;
	}
	public void setQuestionTypeID(Long questionTypeID) {
		this.questionTypeID = questionTypeID;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	
	

}
