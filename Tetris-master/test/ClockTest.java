import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.psnbtech.Clock;

class ClockTest {

    private Clock clock;

    @BeforeEach
    void setUp() {//throws Exception {
        clock = new Clock(10);
    }

    @AfterEach
    void tearDown() {//throws Exception {
        clock = null;
    }

    @Test
    void testClock() {
        assertNotNull(clock);//check if clock object is made
        assertFalse(clock.isPaused());//should be false
    }

    @Test
    void testSetPause() {
        clock.setPaused(true);
        assertTrue(clock.isPaused());

    }

    @Test
    void testSetPause_2() {

        clock.setPaused(false);
        assertFalse(clock.isPaused());
    }
    
    @Test
    void testPeakElapsedCycle() throws Exception {
    	Thread.sleep(500);
    	
    	clock.update();
    	assertTrue(clock.peekElapsedCycle());
    }

    @Test 
    void testUpdate() throws Exception{

        Thread.sleep(600);//simulate time passing

        clock.update();
        assertTrue(clock.hasElapsedCycle());
    }


    @Test 
    void testUpdate2() throws Exception{
        clock.setPaused(true);
        Thread.sleep(600);

        clock.update();
        clock.setPaused(false); // Unpause the clock
        Thread.sleep(600); // Wait again

        clock.update(); // Now it should count cycles
        assertTrue(clock.hasElapsedCycle());


    }

}