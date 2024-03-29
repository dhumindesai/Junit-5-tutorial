import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("When Testing MathUtils")
class MathUtilsTest {

    MathUtils mu;
    MathUtilsHelperService  mathUtilsHelperService = mock(MathUtilsHelperService.class);

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
         mu = new MathUtils(mathUtilsHelperService);
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
    @Tag("UnitTest")
    public void testMultiply(TestReporter testReporter, TestInfo testInfo){
        testReporter.publishEntry("when running "+ testInfo.getDisplayName() + "in tag " + testInfo.getTags());
        //assertEquals(4,mu.multiply(2,2));
        assertAll(() -> assertEquals(4,mu.multiply(2,2)),
                () -> assertEquals(0,mu.multiply(2,0)),
                () -> assertEquals(-2,mu.multiply(2,-1))
                );
    }

    @RepeatedTest(3)
    @EnabledOnOs(OS.MAC)
    @Tag("UnitTest")
    void testCalculateCircleAria(RepetitionInfo repetitionInfo){
        System.out.println("Rep: " + Integer.toString(repetitionInfo.getCurrentRepetition()));
        boolean isServerUp = true;
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

    @Test
    @Tag("Mockito")
    @DisplayName("perform test")
    void testPerform(TestReporter testReporter, TestInfo testInfo){
        testReporter.publishEntry("when running "+ testInfo.getDisplayName() + " in tag " + testInfo.getTags());
        when(mathUtilsHelperService.calculateResult(2,3)).thenReturn(5);
        assertEquals(10,mu.perform(2,3));
        verify(mathUtilsHelperService).calculateResult(2,3);
    }
}