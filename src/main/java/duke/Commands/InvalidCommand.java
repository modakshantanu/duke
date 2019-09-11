package duke.Commands;

import duke.StorageHandler;
import duke.TaskList;
import duke.Ui;

import java.util.ArrayList;

/**
 * Any Command that is invalid
 * When executed, it shows an "Invalid Command" message to the user
 */
public class InvalidCommand extends Command {

    private String message = "Invalid Command!";

    public InvalidCommand() {}
    public InvalidCommand(String message) {  this.message = message;  }

    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storageHandler) {
        ui.printLines(message);
    }

}
