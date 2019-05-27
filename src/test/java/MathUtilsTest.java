import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void add() {
        MathUtils mu = new MathUtils();
        int expected = 2;
        int actual = mu.add(1,1);

        assertEquals(expected, actual);
    }
}