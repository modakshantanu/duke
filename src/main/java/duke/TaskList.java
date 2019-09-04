package duke;

import duke.Tasks.Task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> taskList = new ArrayList<Task>();

    public void addTask(Task t) {
        taskList.add(t);
    }

    public Task deleteTask(int index) {
        return taskList.remove(index);
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
    public String[] filterToStringArray(String word) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            String[] tokens = task.toString().split(" ");
            for (String token: tokens) {
                if (token.equalsIgnoreCase(word) || word.isBlank()) {
                    temp.add(i+1 + ". " + task.toString());
                    break;
                }
            }
        }
        return temp.toArray(new String[0]);
    }


    public void setCompleted(int index, boolean isCompleted) {
        taskList.get(index).setCompleted(isCompleted);
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
