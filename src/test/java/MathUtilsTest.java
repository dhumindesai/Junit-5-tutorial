import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testAdd() {
        MathUtils mu = new MathUtils();
        int expected = 2;
        int actual = mu.add(1,1);

        assertEquals(expected, actual);
    }

    @Test
    void testCalculateCircleAria(){
        MathUtils mu = new MathUtils();
        assertEquals(314.1592653589793,mu.calculateCircleArea(10), "Must return correct circle area");
    }
}