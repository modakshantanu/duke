package duke.Tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Parent class of all types of Tasks stored in the task list
 */
public class Task {



    protected String description = "";
    protected boolean isCompleted = false;

    Task(String description) {
        this.description = description;
    }

    /**
     * Converts a line from the text storage file to the correct task object
     * @param s The line in the storage file
     * @return The correct Task/child class object for that line
     */
    public static Task parseStorageString(String s) {
        String[] tokens = s.split("\\|");

        if (tokens.length != 3 && tokens.length != 4) {
            System.out.println("File Handling Errrr");
            return  new Task("ERROR");
        }
        Task temp;
        switch (tokens[0]) {
            case "T":
                temp = new Todo(tokens[2]);
                break;
            case "E":
                temp = new Event(tokens[2], tokens[3]);
                break;
            case "D":
                temp = new Deadline(tokens[2], tokens[3]);
                break;
            default:
                System.out.println("File handling errorrr");
                return new Task("Err");
        }

        temp.setCompleted(tokens[1].equals("1"));
        return temp;

    }

    /**
     *
     * @param dateString The string inputted by the user as a date
     * @return The Date object
     */
    static Date parseDateString(String dateString) {
        String[] formats = {"d/M/y HHmm"};
        for (String format : formats) {
            try {
                return new SimpleDateFormat(format).parse(dateString);
            } catch(ParseException ignored) {}
        }

        return null;
    }

    /**
     *
     * @return A string representation of the Task for display to the user
     */
    public String toString() {
        String message = description;
        if (isCompleted) {
            message = "[✓] " + message;
        } else {
            message = "[✗] " + message;
        }
        return message;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    /**
     *
     * @return A string representation of the Task for putting in the storage file
     */
    public String toStorageString() {
        return (isCompleted?"1":"0") + "|" + description;
    }




}
