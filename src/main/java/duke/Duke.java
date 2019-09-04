package duke;


import duke.Commands.Command;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Duke extends Application{

    private static final String horizontalLine = "____________________________________________________________";
   // private static ArrayList<duke.Tasks.Task> taskList = new ArrayList<duke.Tasks.Task>();
    private static TaskList taskList = new TaskList();
    private static StorageHandler storage = new StorageHandler("data.txt");
    private static Ui ui = new Ui();
    private static Parser parser = new Parser();


    public static void main(String[] args) {


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

    @Override
    public void start(Stage stage) throws Exception {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        helloWorld.setFont(new Font(50));
        Scene scene = new Scene(helloWorld,200,200); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.

    }
}
