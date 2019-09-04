package duke;

import java.util.ArrayList;

public class Ui {

    private final String horizLine = "____________________________________________________________";

    public void printHorizLine() {
        System.out.println(horizLine);
    }
    public void printLines(String ...strings) {
        System.out.println(horizLine);
        for (String s: strings) {
            System.out.println(s);
        }
        System.out.println(horizLine);
    }
    public void printUnformattedLines(String ...strings) {
        for (String s: strings) {
            System.out.println(s);
        }
    }

    public void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);
    }

}
