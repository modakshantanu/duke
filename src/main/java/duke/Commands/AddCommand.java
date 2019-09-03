package duke.Commands;

import duke.StorageHandler;
import duke.TaskList;
import duke.Tasks.Todo;
import duke.Ui;

public class TodoCommand implements Command {

    private String description;

    TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storageHandler) {
        Todo todo = new Todo(description);
        taskList.addTask(todo);
        ui.printLines("Added todo" + todo.toString());
    }
}
