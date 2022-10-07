
public class Task {
	private int iD;
	private String taskTypeID;
	private String requirementName;
	private String date;
	private float planFrom;
	private float planTo;
	private String assignee;
	private String expert;

	public Task() {
	}

	public Task(int iD, String taskTypeID, String requirementName, String date, float planFrom, float planTo,
			String assignee, String expert) {
		this.iD = iD;
		this.taskTypeID = taskTypeID;
		this.requirementName = requirementName;
		this.date = date;
		this.planFrom = planFrom;
		this.planTo = planTo;
		this.assignee = assignee;
		this.expert = expert;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getTaskTypeID() {
		return taskTypeID;
	}

	public void setTaskTypeID(String taskTypeID) {
		this.taskTypeID = taskTypeID;
	}

	public String getRequirementName() {
		return requirementName;
	}

	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPlanFrom() {
		return planFrom;
	}

	public void setPlanFrom(float planFrom) {
		this.planFrom = planFrom;
	}

	public float getPlanTo() {
		return planTo;
	}

	public void setPlanTo(float planTo) {
		this.planTo = planTo;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getExpert() {
		return expert;
	}

	public void setExpert(String expert) {
		this.expert = expert;
	}

}
