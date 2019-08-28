public class Deadline extends Task{

    private String dueDate = "";
    Deadline(String description,String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + this.dueDate + ")";
    }
}
