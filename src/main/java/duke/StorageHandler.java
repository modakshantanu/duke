
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageHandler {

    private String path = "data.txt";
    private File file;
    StorageHandler() {
        file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    void addTask(Task task) {
        try {
            Files.write(Paths.get(path),task.toStorageString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
