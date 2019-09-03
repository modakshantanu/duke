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

}
