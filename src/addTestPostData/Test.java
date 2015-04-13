package addTestPostData;



public class Test {
	
	public Long id;
    public Long classID;
	public double timeLimit;
	public double totalMark;
	
	
	public Test(Long id, Long classID, double timeLimit, double totalMark) {
		super();
		this.id = id;
		this.classID = classID;
		this.timeLimit = timeLimit;
		this.totalMark = totalMark;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getClassID() {
		return classID;
	}


	public void setClassID(Long classID) {
		this.classID = classID;
	}


	public double getTimeLimit() {
		return timeLimit;
	}


	public void setTimeLimit(double timeLimit) {
		this.timeLimit = timeLimit;
	}


	public double getTotalMark() {
		return totalMark;
	}


	public void setTotalMark(double totalMark) {
		this.totalMark = totalMark;
	}
	
	
	
	

}
