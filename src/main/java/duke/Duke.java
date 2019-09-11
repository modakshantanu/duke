package duke;


import duke.Commands.Command;
import duke.Tasks.Deadline;
import duke.Tasks.Event;
import duke.Tasks.Task;
import duke.Tasks.Todo;

import java.util.Scanner;


public class Duke {

    private static final String horizontalLine = "____________________________________________________________";
   // private static ArrayList<duke.Tasks.Task> taskList = new ArrayList<duke.Tasks.Task>();
    private static TaskList taskList = new TaskList();
    private static StorageHandler storage = new StorageHandler("data.txt");
    private static Ui ui = new Ui();
    private static Parser parser = new Parser();

    public void run() {
        taskList.setTaskList(storage.getData());
        Scanner scanner = new Scanner(System.in);
        String input;
        ui.printWelcome();

        while (true) {

            input = scanner.nextLine();
            if (input.isBlank()) {
                continue;
            }
            Command c = parser.parseLine(input, taskList.size());
            c.execute(ui, taskList, storage);
            if (c.isBye) {  return;  }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }

}
