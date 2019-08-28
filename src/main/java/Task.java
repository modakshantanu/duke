


public class Task {


    protected String description = "";
    protected boolean isCompleted = false;

    Task(String description) {
        this.description = description;
    }

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

}
