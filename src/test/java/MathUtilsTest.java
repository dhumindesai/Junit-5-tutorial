import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Testing add method from MathUtils")
    void testAdd() {
        int expected = 2;
        int actual = mu.add(1,1);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculateCircleAria(){
        assertEquals(314.1592653589793,mu.calculateCircleArea(10), "Must return correct circle area");
    }

    @Test
    void testDivideThrowsArithmaticException(){
        assertThrows(ArithmeticException.class,() -> mu.divide(1,0));
    }

    @Test
    @DisplayName("Multiply method from MathUtil")
    @Disabled
    void testMultiply(){
        fail("TDD. Work in progress");
    }
}