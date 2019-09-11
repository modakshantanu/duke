package duke;

import java.util.ArrayList;

/**
 * Handles printing output to the user
 */
public class Ui {

    private final String horizLine = "____________________________________________________________";

    /**
     * Prints a single horizontal line
     */
    public void printHorizLine() {
        System.out.println(horizLine);
    }

    /**
     * Prints one of more strings between horizontal lines
     * @param strings Variable number of strings / String array
     */
    public void printLines(String ...strings) {
        System.out.println(horizLine);
        for (String s: strings) {
            System.out.println(s);
        }
        System.out.println(horizLine);
    }

    /**
     * Same as printLines, without horizontal Lines at the top and bottom
     */
    public void printUnformattedLines(String ...strings) {
        for (String s: strings) {
            System.out.println(s);
        }
    }

    /**
     * Print the welcome message
     */
    public void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);
    }

}
