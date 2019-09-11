package duke.Commands;


import duke.StorageHandler;
import duke.TaskList;
import duke.Ui;

/**
 * Parent class for all commands
 */
public abstract class Command {

    public boolean isBye = false;

    /**
     * Executes the actions that need to be taken for that command
     * Action varies for each type of command
     * @param ui The Ui object (for outputting to the user)
     * @param taskList The list of tasks that will be read/updated
     * @param storageHandler The storage handler for the program
     */
    public abstract void execute(Ui ui, TaskList taskList, StorageHandler storageHandler);

}
