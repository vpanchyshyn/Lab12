import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task2.Signature;

import static org.junit.jupiter.api.Assertions.*;

public class TestSignature {

    @Test
    public void testSignatureApply() {
        Signature<String> signature = new Signature<>(s -> {});
        signature.apply("TestArg");

        assertNotNull(signature.getId());
    }
}
