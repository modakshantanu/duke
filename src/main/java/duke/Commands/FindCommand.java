package duke.Commands;


import duke.StorageHandler;
import duke.TaskList;
import duke.Ui;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(Ui ui, TaskList taskList, StorageHandler storageHandler) {

        ui.printHorizLine();
        ui.printUnformattedLines("Here are the matching tasks:");
        ui.printUnformattedLines(taskList.filterToStringArray(keyword));
        ui.printHorizLine();

    }
}
