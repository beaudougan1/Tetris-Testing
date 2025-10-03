import java.awt.Robot;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.psnbtech.Tetris;
import org.psnbtech.TileType;

class TetrisTest {
	//Used to call the tetris class
	private Tetris tetris;
	//Used to simulate user input in the tetris game
	private Robot robot;
	//used to create a thread to use startGame() to allow the other lines of code to run using sleep
	Thread gameThread;
	//Used to take in error data to test if errors are printed to console
	ByteArrayOutputStream errOut;

	@BeforeEach
	void setUp() throws Exception {
		//initialize the tetris object
		tetris = new Tetris();
		//initialize the robot object
		robot = new Robot();	
		//initialize the game thread to run startGame() on start()
		gameThread = new Thread(() -> tetris.startGame());
		//initialize the byte output stream for error 
		errOut = new ByteArrayOutputStream();
		//set the error output to print to errOut instead of System.err
		System.setErr(new PrintStream(errOut));
	}

	@AfterEach
	void tearDown() throws Exception {
		//dispose of tetris
		tetris.dispose();
		//set tetris to null
		tetris = null;	
		//set robot to null
		robot = null;
		//set error output back to the console
		System.setErr(new PrintStream(System.err));
	}
	
	@Test
	void rotatePiece_notValidandEmpty() throws Exception{
		gameThread.start();
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(100);
		
		for(int j = 0; j < 22; j++) {
			for(int i = 0; i < 10; i++) {
				tetris.board.setTile(i, j, TileType.TypeI);
			}
		}
		
		Thread.sleep(100);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(200);
		
		assertFalse(tetris.board.isValidAndEmpty(tetris.currentType, tetris.getPieceCol(), tetris.getPieceRow(), tetris.getPieceRotation()));
		
	} //1,3,5,7,9,11
	
	@Test
	void rotatePiece_blockedLeft() throws Exception {
		gameThread.start();
		
		Thread.sleep(200);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		
		tetris.currentType = TileType.TypeI;
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		int oldCol = tetris.getPieceCol();
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		assertTrue(oldCol != tetris.getPieceRow());
	}//1,2,5,7,9,10,11
	
	@Test
	void rotatePiece_blockedRight() throws Exception {
		gameThread.start();
		
		Thread.sleep(200);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		
		tetris.currentType = TileType.TypeI;
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		
		Thread.sleep(200);
		
		int oldCol = tetris.getPieceCol();
		
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		
		assertTrue(oldCol != tetris.getPieceRow());
	}//1,3,4,5,7,9,10,11
	
	@Test
	void rotatePiece_blockedBottom() throws Exception {
		gameThread.start();
		
		Thread.sleep(200);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		
		tetris.currentType = TileType.TypeI;
		
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(600);
		robot.keyRelease(KeyEvent.VK_S);
		
		Thread.sleep(500);
		
		int oldRow = tetris.getPieceRow();
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		assertTrue(oldRow != tetris.getPieceRow());
	}//1,3,5,6,9,10,11
	
	@Test
	void rotatePiece_blockedTop() throws Exception {
		gameThread.start();
		
		Thread.sleep(200);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(200);

		tetris.currentType = TileType.TypeI;
		tetris.currentRow = -1;
		int oldRow = tetris.getPieceRow();
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(100);
		
		assertTrue(oldRow != tetris.getPieceRow());
	} //1,3,5,7,8,9,10,11
	
	@Test
	void spawnPiece_GameOver() throws Exception {
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(200);
		
		for(int j = 0; j < 22; j++) {
			for(int i = 0; i < 10; i++) {
				tetris.board.setTile(i, j, TileType.TypeI);
			}
		}
		Thread.sleep(1000);
		
		assertTrue(tetris.isGameOver());
	} //1,2,3
	
	@Test
	void spawnPiece_NoGameOver() throws Exception {
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_S);
		
		Thread.sleep(1000);
		assertFalse(tetris.isGameOver());
	} //1,3
	
	
	//expects score to be zero since no lines have been cleared yet
	@Test
	void updateGame_NoScore() throws Exception {
		
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_S);
		
		Thread.sleep(1000);
		assertEquals(0, tetris.getScore());
		
	}
	
	@Test
	void updateGame_Score() throws Exception{
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		for(int i = 0; i < 10; i++) {
			tetris.board.setTile(i, 21, TileType.TypeI);
		}
		
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(200);
		
		assertEquals(tetris.getScore(), 100);
	}
	//1,3,4,5,6 Score should be 100 because only one cleared row
	
	@Test
	void updateGame_currentRow() throws Exception {
		
		gameThread.start();
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		int oldRow = tetris.getPieceRow();
		
		Thread.sleep(1500);
		
		assertTrue(tetris.getPieceRow() > oldRow);
		
	}
	
	@Test
	void testTetris_A1() throws Exception {
		
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		Thread.sleep(500);
		
		int check = tetris.getPieceCol();
		int test = tetris.getPieceType().getSpawnColumn();

		assertEquals(check, --test);
	} //1,5,6,7,23,25
	
	@Test 
	void testTetris_A2() throws Exception {
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		
		Thread.sleep(500);
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		Thread.sleep(500);
		
		int test = tetris.getPieceType().getSpawnColumn();
		int check = tetris.getPieceCol();
		
		assertEquals(check, test);
	} //1,4,16,17,19
	
	@Test
	void testTetris_Q1() throws Exception{
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(500);
		
		int check = tetris.getPieceRotation();
		assertEquals(check, 3);
	} //1,8,9,16,17,19
	
	@Test
	void testTetris_Q2() throws Exception{
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		
		Thread.sleep(500);
		
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		
		Thread.sleep(500);
		
		int check = tetris.getPieceRotation();
		assertEquals(check, 0);
	} //1,8,9,16,17,19
	
	@Test
	void testTetris_E1() throws Exception{
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		
		Thread.sleep(500);
		
		int check = tetris.getPieceRotation();
		assertEquals(check, 1);
	}//1,10,11,16,17,19
	
	@Test
	void testTetris_E2() throws Exception{
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		
		Thread.sleep(500);
		
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		
		Thread.sleep(500);
		
		int check = tetris.getPieceRotation();
		
		assertEquals(check, 0);
	}//1,10,16,17,19
	
	@Test
	void testTetris_Enter1() throws Exception{
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		
		assertFalse(tetris.isGameOver());
	} //1,14,15,16,17,19
	
	@Test
	void testTetris_Enter2() throws Exception{
		gameThread.start();
		
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		assertFalse(tetris.isNewGame());
	}//1,14,16,17,19
	
	@Test
    void testTetris_S1() throws Exception {

        gameThread.start();

        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(200);
        
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);

        Thread.sleep(200);

        assertFalse(tetris.isPaused());
        //expects is paused to be false
        //expected path:[1,2,3,16,17,18,19]

    }
	
	@Test
    void testTetris_S4() throws Exception {

        gameThread.start();

        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(200);
        
        robot.keyPress(KeyEvent.VK_S);
        //robot.keyRelease(KeyEvent.VK_S);

        Thread.sleep(200);

        assertFalse(tetris.isPaused());
        //expects is paused to be false
        //expected path:[1,2,3,16,17,19]

    }

	@Test
    void testTetris_S2() throws Exception {

        gameThread.start();

        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_P);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_S);

        Thread.sleep(200);

        assertTrue(tetris.isPaused());

    }

	@Test
    void testTetris_S3() throws Exception {

        gameThread.start();

        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_P);
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);

        Thread.sleep(200);

        assertTrue(tetris.isPaused());
    }
	
	@Test
    void testTetris_D1() throws Exception {

        gameThread.start();

        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(200);
      
        
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);

        Thread.sleep(200);
       int test = tetris.getPieceType().getSpawnColumn();

        assertTrue(tetris.getPieceCol() == ++test );
        //expects is paused to be true should move to the right
        //expected path:[1,6,7,16,17,19]

    }
	
	@Test
    void testTetris_D2() throws Exception {

        gameThread.start();

        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_P);
        
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);

        Thread.sleep(200);

        int test = tetris.getPieceType().getSpawnColumn();
        assertTrue(tetris.getPieceCol() == test );
        
        //expects is paused to be true
        //expected path:[1,6,16,17,19]

    }
	
	@Test
    void testTetris_P1() throws Exception {

        gameThread.start();

        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(200);
        
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);

        Thread.sleep(200);

        assertTrue(tetris.isPaused());
        
        //expects isPaused() to be true
        //expected path:[1,12,13,16,17,19]]
    }
	
	@Test
    void testTetris_P2() throws Exception {

        gameThread.start();

        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);

        Thread.sleep(200);

        assertFalse(tetris.isPaused());
        
        //expects is paused to be false doesn't enter if
        //expected path:[1,12,16,17,19]
    }
	
	@Test
	void testStartGame_NoInterrupt() throws Exception{
		gameThread.start();
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_S);
		String error = errOut.toString();
        
	    Thread.sleep(200);
	    assertFalse(error.contains("sleep interrupted"));
		
	}//1,2,3,4,5,6,7,8,10
	
	@Test
	void testStartGame_Interrupt() throws Exception{		
			
		gameThread.start();
		Thread.sleep(200);
		
		robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(300);
	        
	    gameThread.interrupt();
	    
	    Thread.sleep(200);
	    String error = errOut.toString();
	        
	    Thread.sleep(200);
	    assertTrue(error.contains("sleep interrupted"));
	} //1,2,3,5,7,8,9,10
}