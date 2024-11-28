import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task1.ATM;

import static org.junit.jupiter.api.Assertions.*;

public class TestATM {

    @Test
    public void testValidAmountSingleDenomination() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.getMeMoney(500));
    }

    @Test
    public void testValidAmountMultipleDenominations() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.getMeMoney(700));
    }

    @Test
    public void testValidAmountWithAllDenominations() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.getMeMoney(800));
    }

    @Test
    public void testInvalidAmount() {
        ATM atm = new ATM();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> atm.getMeMoney(350));
        assertEquals("Invalid amount", exception.getMessage());
    }

    @Test
    public void testZeroAmount() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.getMeMoney(0));
    }

    @Test
    public void testLargeAmount() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.getMeMoney(1500));
    }
}
