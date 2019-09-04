package duke;


import duke.Commands.Command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Duke extends Application{

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image user;
    private Image duke;


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


        try {
            user = new Image(new FileInputStream("src/main/resources/images/DaUser.png"));
            duke = new Image(new FileInputStream("src/main/resources/images/DaDuke.png"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Step 1. Setting up required components

        //The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox(); // Arranges Children vertically
        scrollPane.setContent(dialogContainer); // put the VBox in scrollPane

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, sendButton,userInput);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();

        //Step 2. Formatting the window to look as expected
        stage.setTitle("duke.Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        // Not sure why they use Preferred size but it's like setting the size
        mainLayout.setPrefSize(400.0, 600.0);
        scrollPane.setPrefSize(385, 535);

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);
        userInput.setPrefWidth(325.0);
        sendButton.setPrefWidth(55.0);


        // value is the pixels offset
        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);


        //Step 3. Add functionality to handle user input.

        // Button clicked
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });


        // Default onAction for textInput is pressing Enter
        userInput.setOnAction((event) -> {
            handleUserInput();
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));
    }



    private void handleUserInput() {
        String userText = userInput.getText();
        String dukeText = getResponse(userInput.getText());
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, user),
                DialogBox.getDukeDialog(dukeText, duke)
        );
        userInput.clear();
    }

    String getResponse(String input) {
        return "duke.Duke heard: " + input;
    }


}
