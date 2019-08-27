import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String horizontalLine = "____________________________________________________________";

        System.out.println("Hello from\n" + logo);

        Scanner scanner = new Scanner(System.in);

        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println(horizontalLine);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(horizontalLine);
                return;
            }

            System.out.println(horizontalLine);
            System.out.println(input);
            System.out.println(horizontalLine);

        }


    }
}
