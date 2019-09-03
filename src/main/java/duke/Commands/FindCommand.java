package duke.Commands;


import duke.StorageHandler;
import duke.TaskList;
import duke.Ui;

public class ListCommand implements Command {

    String keyword;

    ListCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storageHandler) {
        ui.printLines(taskList.filterToStringArray(keyword).toArray(new String[0]));
    }
}
