package duke;

import duke.Tasks.Task;

import java.util.ArrayList;

/**
 * Handles storage of Tasks (in RAM) while the program is running
 */
public class TaskList {

    private ArrayList<Task> taskList = new ArrayList<Task>();

    /**
     * Adds t to the taskList
     * @param t new task
     */
    public void addTask(Task t) {
        taskList.add(t);
    }

    /**
     * deletes task at the given index
     * @param index The index (must be a valid index)
     * @return The deleted task
     */
    public Task deleteTask(int index) {
        return taskList.remove(index);
    }

    /**
     * @param word A single word without spaces to be matched with
     * @return The subset of taskList whose descriptions contain that word
     */
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

    /**
     * Same as filterByKeyword, but returns an Array of Strings in a suitable format for output
     *
     */
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

    /**
     * Sets isCompleted for one element in taskList
     * @param index The index of the taskList element set to be completed
     * @param isCompleted Whether or not the task is completed
     */
    public void setCompleted(int index, boolean isCompleted) {
        taskList.get(index).setCompleted(isCompleted);
    }

    /**
     *
     * @return size of taskList
     */
    public int size() {
        return taskList.size();
    }

    /**
     *
     * @param index index of the required element
     * @return The element of taskList at that index
     */
    public Task getByIndex(int index) {
        return taskList.get(index);
    }

    /**
     *
     * @return the entire taskList
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     *
     * @param taskList the value that taskList is set to
     */
    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }
}
