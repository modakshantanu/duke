package duke.Commands;

import duke.StorageHandler;
import duke.TaskList;
import duke.Tasks.Task;
import duke.Ui;

/**
 * Command requesting to delete a task
 */
public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storage) {
        Task deleted = taskList.deleteTask(index);
        storage.saveData(taskList.getTaskList());
        ui.printLines("Removed this task:" , deleted.toString());
    }
}
