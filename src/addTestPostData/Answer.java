package addTestPostData;


public class Answer {
	
	private Long id;
	private boolean correctAnswer;
	
	
	public Answer(Long id,boolean correctAnswer) {
		super();
		this.id = id;
		this.correctAnswer = correctAnswer;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}


	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
	
	

}
