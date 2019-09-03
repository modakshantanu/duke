


import java.util.Scanner;


public class Duke {

    private static final String horizontalLine = "____________________________________________________________";
   // private static ArrayList<Task> taskList = new ArrayList<Task>();
    private static TaskList taskList = new TaskList();

    private static StorageHandler storage;


    public static void main(String[] args) {

        storage = new StorageHandler();
        taskList.setTaskList(storage.getData());


        String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);
        Scanner scanner = new Scanner(System.in);

        String input;

        while (true) {
            input = scanner.nextLine();

            // remove all occurrences of | as it is a separator for file storage
            input = input.replace("|","");



            if (input.equals("bye")) {
                printFormattedLine("Bye. Hope to see you again soon!");
                return;
            } else if (input.startsWith("list")) {
                printList();
            } else if (input.startsWith("done") || input.startsWith("delete")) {
                // parse the input string and get the index of the task that needs to be marked done
                int doneIndex;
                try {
                    doneIndex =  Integer.parseInt(input.substring(input.lastIndexOf(" ") + 1)) - 1;
                } catch (Exception e) {
                    // Error if the string after "done" is not an integer
                    printFormattedLine("That task doesn't exist");
                    continue;
                }

                // error handling if the index is not in the array
                if (doneIndex < 0 || doneIndex >= taskList.size()) {
                    printFormattedLine("That task doesn't exist");
                    continue;
                }

                if (input.startsWith("delete")) {
                    deleteTask(doneIndex);
                    continue;
                }

                taskList.getByIndex(doneIndex).setCompleted(true);

                System.out.println(horizontalLine);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(taskList.getByIndex(doneIndex).toString());
                System.out.println(horizontalLine);

            } else if (input.startsWith("todo")) {
                String desc = input.substring(4);
                if (desc.isBlank()) {
                    printFormattedLine("Todo cannot be empty");
                    continue;
                }
                addItem(new Todo(desc));

            } else if (input.startsWith("deadline")) {
                String temp  = input.substring(8);
                String[] tokens = temp.split("/by");
                if (tokens.length != 2 || tokens[0].isBlank() || tokens[1].isBlank()) {
                    System.out.println("Invalid format, use \"deadline <Description> /by <Date|dd/MM/yyyy hhmm>\"");
                    continue;
                }
                addItem(new Deadline(tokens[0],tokens[1]));
            } else if (input.startsWith("event") ) {
                String temp  = input.substring(5);
                String[] tokens = temp.split("/at");
                if (tokens.length != 2 || tokens[0].isBlank() || tokens[1].isBlank()) {
                    System.out.println("Invalid format, use \"event <Description> /at <Date|dd/MM/yyyy hhmm>\"");
                    continue;
                }
                addItem(new Event(tokens[0],tokens[1]));
            }  else { // only add non-empty strings
                System.out.println("Invalid command");
            }


        }


    }

    // Prints one String between 2 horizontal Lines
    private static void printFormattedLine(String line) {
        System.out.println(horizontalLine);
        System.out.println(line);
        System.out.println(horizontalLine);
    }

    private static void addItem(Task item) {
        taskList.addTask(item);
        storage.addTask(item);
        printFormattedLine("added: " + item);

    }

    private static void deleteTask(int index) {



        taskList.deleteTask(index);
        storage.saveData(taskList.getTaskList());
        printFormattedLine("Task " + ++index + " deleted");

    }

    private static void printList() {
        System.out.println(horizontalLine);

        // Print each element of list with numbering
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i+1 + ". " + taskList.getByIndex(i).toString());
        }
        System.out.println(horizontalLine);
    }

}
