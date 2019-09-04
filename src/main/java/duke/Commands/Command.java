package duke.Commands;


import duke.StorageHandler;
import duke.TaskList;
import duke.Ui;

public abstract class Command {

    public boolean isBye = false;
    public abstract void execute(Ui ui, TaskList taskList, StorageHandler storageHandler);

}
