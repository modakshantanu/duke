package duke.Commands;

import duke.CommandType;
import duke.StorageHandler;
import duke.TaskList;
import duke.Tasks.Deadline;
import duke.Tasks.Event;
import duke.Tasks.Task;
import duke.Tasks.Todo;
import duke.Ui;

/**
 * Command to Add a Task
 */
public class AddCommand extends Command {

    private CommandType type = CommandType.INVALID;
    private String description = "";
    private String date = "";

    /**
     *
     * @param type The type of Task
     * @param tokens 1st element - the description of the task
     *               2nd optional element - The date (for Events and Deadlines)
     */
    public AddCommand(CommandType type, String ...tokens) {
        this.type = type;
        this.description = tokens[0];
        if (tokens.length == 2) {
            this.date = tokens[1];
        }
    }

    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storageHandler) {

        Task task = null;

        switch (type) {
            default:
            case TODO:
                task = new Todo(description);
                break;
            case EVENT:
                task = new Event(description,date);
                break;
            case DEADLINE:
                task = new Deadline(description,date);
                break;
        }
        taskList.addTask(task);
        storageHandler.addTask(task);
        ui.printLines("Added task: " + task.toString());
    }
}
