package duke.Commands;

import duke.StorageHandler;
import duke.TaskList;
import duke.Ui;

public class ByeCommand extends Command {

    public ByeCommand() {
        isBye = true;
    }
    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storageHandler) {
        ui.printLines("Goodbye");
    }
}
