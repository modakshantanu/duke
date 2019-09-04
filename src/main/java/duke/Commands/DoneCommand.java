package duke.Commands;

import duke.StorageHandler;
import duke.TaskList;
import duke.Ui;

public class DoneCommand extends Command {

    int index;

    public DoneCommand(int index) {  this.index = index;  }

    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storageHandler) {
        taskList.setCompleted(index,true);
        storageHandler.saveData(taskList.getTaskList());
        ui.printLines("Task set as done:", taskList.getByIndex(index).toString());
    }
}
