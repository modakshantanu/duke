import java.util.ArrayList;

public class Ui {

    private final String horizLine = "____________________________________________________________";

    void printHorizLine() {
        System.out.println(horizLine);
    }
    void printLines(String ... strings) {
        System.out.println(horizLine);
        for (String s: strings) {
            System.out.println(s);
        }
        System.out.println(horizLine);
    }

    void printTasks(ArrayList<Task> tasks) {
        System.out.println(horizLine);


    }

}
