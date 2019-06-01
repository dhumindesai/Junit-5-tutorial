import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When Testing MathUtils")
class MathUtilsTest {

    MathUtils mu;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All..");
    }

    @AfterAll
    static  void afterAll(){
        System.out.println("After All..");
    }

    @BeforeEach
    void init(){
         mu = new MathUtils();
    }

    @AfterEach
    void cleanUp(){
        System.out.println("Cleaning Up..");
    }

    @Nested
    @DisplayName("Add method")
    class testAdd{
        @Test
        @DisplayName("when adding positives")
        void testAddPositives() {
            int expected = 2;
            int actual = mu.add(1, 1);
            assertEquals(expected, actual, "should return postive integer");
        }
        @Test
        @DisplayName("when adding negatives")
        void testAddNegatives() {
            int expected = -2;
            int actual = mu.add(-1, -1);
            assertEquals(expected, actual,"should return negative integer");
        }
    }

    @Test
    public void testMultiply(){
        //assertEquals(4,mu.multiply(2,2));
        assertAll(() -> assertEquals(4,mu.multiply(2,2)),
                () -> assertEquals(0,mu.multiply(2,0)),
                () -> assertEquals(-2,mu.multiply(2,-1))
                );
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testCalculateCircleAria(){
        boolean isServerUp = false;
        Assumptions.assumeTrue(isServerUp,"Server is up");
        assertEquals(314.1592653589793,mu.calculateCircleArea(10), "Must return correct circle area");
    }

    @Test
    void testDivideThrowsArithmaticException(){
        assertThrows(ArithmeticException.class,() -> mu.divide(1,0));
    }

    @Test
    @DisplayName("test method from MathUtil")
    @Disabled
    void testMethod(){
        fail("TDD. Work in progress");
    }
}