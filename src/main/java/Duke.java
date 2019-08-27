import java.util.ArrayList;
import java.util.Scanner;


public class Duke {

    private static final String horizontalLine = "____________________________________________________________";
    private static ArrayList<String> taskList = new ArrayList<String>();

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
                System.out.println(horizontalLine);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(horizontalLine);
                return;
            } else if (input.equals("list")) {
                printList();
            } else {
                addItem(input);
            }

        }


    }

    private static void addItem(String item) {
        taskList.add(item);
        System.out.println(horizontalLine);
        System.out.println("added: " + item);
        System.out.println(horizontalLine);
    }

    private static void printList() {
        System.out.println(horizontalLine);

        // Print each element of list with numbering
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i+1 + ". " + taskList.get(i));
        }
        System.out.println(horizontalLine);
    }
}
