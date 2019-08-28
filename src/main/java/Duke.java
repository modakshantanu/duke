import java.util.ArrayList;
import java.util.Scanner;


public class Duke {

    private static final String horizontalLine = "____________________________________________________________";
    private static ArrayList<Task> taskList = new ArrayList<Task>();

    public static void main(String[] args) {
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
            if (input.equals("bye")) {
                printFormattedLine("Bye. Hope to see you again soon!");
                return;
            } else if (input.startsWith("list")) {
                printList();
            } else if (input.startsWith("done")) {
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

                taskList.get(doneIndex).setCompleted(true);

                System.out.println(horizontalLine);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(taskList.get(doneIndex).toString());
                System.out.println(horizontalLine);
            } else if (input.length() > 0){ // only add non-empty strings
                addItem(input);
            }
        }


    }

    // Prints one String between 2 horizontal Lines
    private static void printFormattedLine(String line) {
        System.out.println(horizontalLine);
        System.out.println(line);
        System.out.println(horizontalLine);
    }

    private static void addItem(String item) {
        taskList.add(new Task(item));
        printFormattedLine("added: " + item);
    }

    private static void printList() {
        System.out.println(horizontalLine);

        // Print each element of list with numbering
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i+1 + ". " + taskList.get(i).toString());
        }
        System.out.println(horizontalLine);
    }

}
