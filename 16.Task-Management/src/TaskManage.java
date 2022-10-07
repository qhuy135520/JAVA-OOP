import java.util.ArrayList;

public class TaskManage {
	ArrayList<Task> task = new ArrayList<>();

	public TaskManage() {
	}

	public TaskManage(ArrayList<Task> task) {
		this.task = task;
	}

	public ArrayList<Task> getTask() {
		return task;
	}

	public void setTask(ArrayList<Task> task) {
		this.task = task;
	}

	public void addTask(Task add) {
		task.add(add);
	}

	public boolean deleteTask(int iD) {
		boolean isExist = false;
		for (int i = 0; i < task.size(); i++) {
			if (task.get(i).getiD() == iD) {
				task.remove(i);
				isExist = true;
			}
		}
		return isExist;
	}
}
