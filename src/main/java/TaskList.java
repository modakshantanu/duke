import java.util.ArrayList;

public class TaskList {


    private ArrayList<Task> taskList = new ArrayList<Task>();

    public void addTask(Task t) {
        taskList.add(t);
    }

    public void deleteTask(int index) {
        taskList.remove(index);
    }

    public ArrayList<Task> filterByKeyword(String word) {
        ArrayList<Task> temp = new ArrayList<Task>();
        for (Task task:taskList) {
            String[] tokens = task.toString().split(" ");
            for (String token: tokens) {
                if (token.equalsIgnoreCase(word)) {
                    temp.add(task);
                    break;
                }
            }
        }
        return temp;
    }

    public int size() {
        return taskList.size();
    }

    public Task getByIndex(int index) {
        return taskList.get(index);
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }
}
