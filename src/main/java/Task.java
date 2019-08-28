


public class Task {

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

    public String toStorageString() {
        return (isCompleted?"1":"0") + "|" + description;
    }




}
