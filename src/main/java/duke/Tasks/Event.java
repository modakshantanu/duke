package duke;

import java.util.Date;

public class Event extends Task{
    private String dueDateString = "";
    private Date dueDate = null; // Used if the date given is in date format

    Event(String description, String dueDate) {
        super(description);
        this.dueDateString = dueDate;
        this.dueDate = Task.parseDateString(dueDateString);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + this.dueDateString + ")";
    }

    @Override
    public String toStorageString() {
        return "E|" + super.toStorageString() + "|" + this.dueDateString;
    }

}
