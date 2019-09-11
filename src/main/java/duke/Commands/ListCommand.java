package duke.Commands;

import duke.StorageHandler;
import duke.TaskList;
import duke.Ui;

/**
 * Command to list all the tasks
 */
public class ListCommand extends Command {
    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storageHandler) {
        ui.printLines(taskList.filterToStringArray(""));
    }

}
