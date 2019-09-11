package duke;

import duke.Tasks.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the storing of data in a text file
 */
public class StorageHandler {

    private String path;
    private File file;

    /**
     *
     * @param path The path + name of the text file to store the data
     */
    StorageHandler(String path) {
        this.path = path;
        file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get the data stored in the text file
     * @return An ArrayList containing all the tasks
     */
    public ArrayList<Task> getData() {
        ArrayList<Task> array = new ArrayList<Task>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (data.isBlank()) {
                    continue;
                }
                array.add(Task.parseStorageString(data));
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return array;

    }

    /**
     * Saves the data passed into the text file
     * Overwrites and old data in the text file
     * @param data The ArrayList of tasks to be saved
     */
    public void saveData(ArrayList<Task> data) {
        try {
            FileWriter writer = new FileWriter(path);
            for (int i = 0; i < data.size(); i++) {
                writer.write(data.get(i).toStorageString() + "\n");
            }
            writer.close();
        } catch (IOException e){
            System.out.println("Error while writing file");
            e.printStackTrace();
        }
    }

    /**
     * Appends the new task data to the end of the text file
     * @param task The new task to be added
     */
    public void addTask(Task task) {
        try {
            Files.write(Paths.get(path),task.toStorageString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
