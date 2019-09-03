package duke;

import java.util.Date;


public class Deadline extends Task{

    private String dueDateString = "";
    private Date dueDate = null;
    Deadline(String description,String dueDate) {
        super(description);
        this.dueDateString = dueDate;
        this.dueDate = parseDateString(dueDateString);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + this.dueDateString + ")";
    }

    @Override
    public String toStorageString() {
        return "D|" + super.toStorageString() + "|" + this.dueDateString;
    }
}
