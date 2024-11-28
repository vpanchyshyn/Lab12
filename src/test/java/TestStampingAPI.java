import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task2.Signature;
import ua.edu.ucu.apps.task2.StampingAPI;
import ua.edu.ucu.apps.task2.Task;

import static org.junit.jupiter.api.Assertions.*;

public class TestStampingAPI {

    @Test
    public void testVisit() {
        String groupUUID = "test-group-uuid";
        StampingAPI stampingAPI = new StampingAPI(groupUUID);
        Task<String> task = new Signature<>(s -> {});

        stampingAPI.visit(task);

        assertEquals(groupUUID, task.getHeader("groupUUID"));
    }
}