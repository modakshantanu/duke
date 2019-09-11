package duke.Tasks;




import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskTest {

    @Test
    public void basicTodoTest() {
        Task t = new Task("Foo Bar");
        assertEquals("[✗] " + "Foo Bar", t.toString());
        t.setCompleted(true);
        assertEquals("[✓] " + "Foo Bar", t.toString());
    }

}
