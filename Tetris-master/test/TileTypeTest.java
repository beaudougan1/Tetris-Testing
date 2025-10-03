
import org.junit.*;
import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.psnbtech.BoardPanel;
import org.psnbtech.TileType;

public class TileTypeTest {
	
	TileType tileI;
	TileType tileJ;
	TileType tileL;
	TileType tileO;
	TileType tileS;
	TileType tileT;
	TileType tileZ;
	@Before
	public void setUp() throws Exception {
		tileI = TileType.TypeI;
		tileJ = TileType.TypeJ;
		tileL = TileType.TypeL;
		tileO = TileType.TypeO;
		tileS = TileType.TypeS;
		tileT = TileType.TypeT;
		tileZ = TileType.TypeZ;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIGetBaseColor() {
		Color test;
		test = new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MAX);
		Assert.assertEquals(tileI.getBaseColor(), test);
	}
	
	@Test
	public void testIGetLightColor() {
		Color test;
		test = tileI.getBaseColor().brighter();
		Assert.assertEquals(test, tileI.getLightColor());
	}
	
	@Test
	public void testIGetDarkColor() {
		Color test;
		test = tileI.getBaseColor().darker();
		Assert.assertEquals(test, tileI.getDarkColor());
	}
	
	@Test
	public void testIGetDimension() {
		int test;
		test = tileI.getDimension();
		Assert.assertEquals(4, test);
	}
	
	@Test
	public void testIGetSpawnColumn() {
		int test;
		test = 5 - (tileI.getDimension() >> 1);
		Assert.assertEquals(test, tileI.getSpawnColumn());
	}
	
	@Test
	public void testIGetSpawnRow() {
		int test;
		test = tileI.getTopInset(0);
		Assert.assertEquals(test, tileI.getSpawnRow());
	}
	
	@Test
	public void testIGetRows() {
		int test;
		test = tileI.getRows();
		Assert.assertEquals(1, test);
	}
	
	@Test
	public void testIGetCols() {
		int test;
		test = tileI.getCols();
		Assert.assertEquals(4, test);
	}
	
	@Test
	public void testIIsTileT() {
		Assert.assertTrue(tileI.isTile(1,1,0));
	}
	
	@Test
	public void testIIsTileF() {
		Assert.assertFalse(tileI.isTile(0, 0, 0));
	}
	
	@Test
	public void testIGetLeftInset() {
		int test;
		test = 2;
		Assert.assertEquals(test, tileI.getLeftInset(1));
	}
	
	@Test
	public void testIGetRightInset() {
		int test;
		test = 2;
		Assert.assertEquals(test, tileI.getRightInset(1));
	}
	
	@Test
	public void testIGetTopInset() {
		int test = 0;
		Assert.assertEquals(test, tileI.getTopInset(1));
	}
	
	@Test
	public void testIgetBottomInset() {
		int test = 1;
		Assert.assertEquals(test, tileI.getBottomInset(1));
	}
	//J
	@Test
	public void testJGetBaseColor() {
		Color test;
		test = new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX);
		Assert.assertEquals(tileJ.getBaseColor(), test);
	}
	
	@Test
	public void testJGetLightColor() {
		Color test;
		test = tileJ.getBaseColor().brighter();
		Assert.assertEquals(test, tileJ.getLightColor());
	}
	
	@Test
	public void testJGetDarkColor() {
		Color test;
		test = tileJ.getBaseColor().darker();
		Assert.assertEquals(test, tileJ.getDarkColor());
	}
	
	@Test
	public void testJGetDimension() {
		int test;
		test = tileJ.getDimension();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testJGetSpawnColumn() {
		int test;
		test = 5 - (tileJ.getDimension() >> 1);
		Assert.assertEquals(test, tileJ.getSpawnColumn());
	}
	
	@Test
	public void testJGetSpawnRow() {
		int test;
		test = tileJ.getTopInset(0);
		Assert.assertEquals(test, tileJ.getSpawnRow());
	}
	
	@Test
	public void testJGetRows() {
		int test;
		test = tileJ.getRows();
		Assert.assertEquals(2, test);
	}
	
	@Test
	public void testJGetCols() {
		int test;
		test = tileJ.getCols();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testJIsTileT() {
		Assert.assertTrue(tileJ.isTile(1,1,0));
	}
	
	@Test
	public void testJIsTileF() {
		Assert.assertFalse(tileJ.isTile(0, 0, 1));
	}
	
	@Test
	public void testJGetLeftInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileJ.getLeftInset(1));
	}
	
	@Test
	public void testJGetRightInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileJ.getRightInset(1));
	}
	
	@Test
	public void testJGetTopInset() {
		int test = 0;
		Assert.assertEquals(test, tileJ.getTopInset(1));
	}
	
	@Test
	public void testJgetBottomInset() {
		int test = 1;
		Assert.assertEquals(test, tileJ.getBottomInset(1));
	}
	
	//L
	
	@Test
	public void testLGetBaseColor() {
		Color test;
		test = new Color(BoardPanel.COLOR_MAX, 127, BoardPanel.COLOR_MIN);
		Assert.assertEquals(tileL.getBaseColor(), test);
	}
	
	@Test
	public void testLGetLightColor() {
		Color test;
		test = tileL.getBaseColor().brighter();
		Assert.assertEquals(test, tileL.getLightColor());
	}
	
	@Test
	public void testLGetDarkColor() {
		Color test;
		test = tileL.getBaseColor().darker();
		Assert.assertEquals(test, tileL.getDarkColor());
	}
	
	@Test
	public void testLGetDimension() {
		int test;
		test = tileL.getDimension();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testLGetSpawnColumn() {
		int test;
		test = 5 - (tileL.getDimension() >> 1);
		Assert.assertEquals(test, tileL.getSpawnColumn());
	}
	
	@Test
	public void testLGetSpawnRow() {
		int test;
		test = tileL.getTopInset(0);
		Assert.assertEquals(test, tileL.getSpawnRow());
	}
	
	@Test
	public void testLGetRows() {
		int test;
		test = tileL.getRows();
		Assert.assertEquals(2, test);
	}
	
	@Test
	public void testLGetCols() {
		int test;
		test = tileJ.getCols();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testLIsTileT() {
		Assert.assertTrue(tileL.isTile(1,1,0));
	}
	
	@Test
	public void testLIsTileF() {
		Assert.assertFalse(tileJ.isTile(0, 0, 1));
	}
	
	@Test
	public void testLGetLeftInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileJ.getLeftInset(1));
	}
	
	@Test
	public void testLGetRightInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileJ.getRightInset(1));
	}
	
	@Test
	public void testLGetTopInset() {
		int test = 0;
		Assert.assertEquals(test, tileJ.getTopInset(1));
	}
	
	@Test
	public void testLgetBottomInset() {
		int test = 1;
		Assert.assertEquals(test, tileJ.getBottomInset(1));
	}
	
	//O
	
	@Test
	public void testOGetBaseColor() {
		Color test;
		test = new Color(BoardPanel.COLOR_MAX, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN);
		Assert.assertEquals(tileO.getBaseColor(), test);
	}
	
	@Test
	public void testOGetLightColor() {
		Color test;
		test = tileO.getBaseColor().brighter();
		Assert.assertEquals(test, tileO.getLightColor());
	}
	
	@Test
	public void testOGetDarkColor() {
		Color test;
		test = tileO.getBaseColor().darker();
		Assert.assertEquals(test, tileO.getDarkColor());
	}
	
	@Test
	public void testOGetDimension() {
		int test;
		test = tileO.getDimension();
		Assert.assertEquals(2, test);
	}
	
	@Test
	public void testOGetSpawnColumn() {
		int test;
		test = 5 - (tileO.getDimension() >> 1);
		Assert.assertEquals(test, tileO.getSpawnColumn());
	}
	
	@Test
	public void testOGetSpawnRow() {
		int test;
		test = tileO.getTopInset(0);
		Assert.assertEquals(test, tileO.getSpawnRow());
	}
	
	@Test
	public void testOGetRows() {
		int test;
		test = tileO.getRows();
		Assert.assertEquals(2, test);
	}
	
	@Test
	public void testOGetCols() {
		int test;
		test = tileO.getCols();
		Assert.assertEquals(2, test);
	}
	
	@Test
	public void testOIsTileT() {
		Assert.assertTrue(tileO.isTile(1,1,0));
	}
	
	/*Cannot be tested O is always a tile
	public void testOIsTileF() {
	}*/
	
	@Test
	public void testOGetLeftInset() {
		int test;
		test = 0;
		Assert.assertEquals(test, tileO.getLeftInset(1));
	}
	
	@Test
	public void testOGetRightInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileO.getRightInset(1));
	}
	
	@Test
	public void testOGetTopInset() {
		int test = 0;
		Assert.assertEquals(test, tileO.getTopInset(1));
	}
	
	@Test
	public void testOgetBottomInset() {
		int test = 1;
		Assert.assertEquals(test, tileO.getBottomInset(1));
	}
	
	//S
	
	@Test
	public void testSGetBaseColor() {
		Color test;
		test = new Color(BoardPanel.COLOR_MIN, BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN);
		Assert.assertEquals(tileS.getBaseColor(), test);
	}
	
	@Test
	public void testSGetLightColor() {
		Color test;
		test = tileS.getBaseColor().brighter();
		Assert.assertEquals(test, tileS.getLightColor());
	}
	
	@Test
	public void testSGetDarkColor() {
		Color test;
		test = tileS.getBaseColor().darker();
		Assert.assertEquals(test, tileS.getDarkColor());
	}
	
	@Test
	public void testSGetDimension() {
		int test;
		test = tileS.getDimension();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testSGetSpawnColumn() {
		int test;
		test = 5 - (tileS.getDimension() >> 1);
		Assert.assertEquals(test, tileS.getSpawnColumn());
	}
	
	@Test
	public void testSGetSpawnRow() {
		int test;
		test = tileS.getTopInset(0);
		Assert.assertEquals(test, tileS.getSpawnRow());
	}
	
	@Test
	public void testSGetRows() {
		int test;
		test = tileS.getRows();
		Assert.assertEquals(2, test);
	}
	
	@Test
	public void testSGetCols() {
		int test;
		test = tileS.getCols();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testSIsTileT() {
		Assert.assertTrue(tileS.isTile(1,1,0));
	}
	
	@Test
	public void testSIsTileF() {
		Assert.assertFalse(tileS.isTile(0, 0, 1));
	}
	
	@Test
	public void testSGetLeftInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileS.getLeftInset(1));
	}
	
	@Test
	public void testSGetRightInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileS.getRightInset(1));
	}
	
	@Test
	public void testSGetTopInset() {
		int test = 0;
		Assert.assertEquals(test, tileS.getTopInset(1));
	}
	
	@Test
	public void testSgetBottomInset() {
		int test = 1;
		Assert.assertEquals(test, tileS.getBottomInset(1));
	}
	
	//T
	
	
	@Test
	public void testTGetBaseColor() {
		Color test;
		test = new Color(128, BoardPanel.COLOR_MIN, 128);
		Assert.assertEquals(tileT.getBaseColor(), test);
	}
	
	@Test
	public void testTGetLightColor() {
		Color test;
		test = tileT.getBaseColor().brighter();
		Assert.assertEquals(test, tileT.getLightColor());
	}
	
	@Test
	public void testTGetDarkColor() {
		Color test;
		test = tileT.getBaseColor().darker();
		Assert.assertEquals(test, tileT.getDarkColor());
	}
	
	@Test
	public void testTGetDimension() {
		int test;
		test = tileT.getDimension();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testTGetSpawnColumn() {
		int test;
		test = 5 - (tileT.getDimension() >> 1);
		Assert.assertEquals(test, tileT.getSpawnColumn());
	}
	
	@Test
	public void testTGetSpawnRow() {
		int test;
		test = tileT.getTopInset(0);
		Assert.assertEquals(test, tileT.getSpawnRow());
	}
	
	@Test
	public void testTGetRows() {
		int test;
		test = tileJ.getRows();
		Assert.assertEquals(2, test);
	}
	
	@Test
	public void testTGetCols() {
		int test;
		test = tileT.getCols();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testTIsTileT() {
		Assert.assertTrue(tileT.isTile(1,1,0));
	}
	
	@Test
	public void testTIsTileF() {
		Assert.assertFalse(tileT.isTile(0, 0, 1));
	}
	
	@Test
	public void testTGetLeftInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileT.getLeftInset(1));
	}
	
	@Test
	public void testTGetRightInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileT.getRightInset(1));
	}
	
	@Test
	public void testTGetTopInset() {
		int test = 0;
		Assert.assertEquals(test, tileT.getTopInset(1));
	}
	
	@Test
	public void testTgetBottomInset() {
		int test = 1;
		Assert.assertEquals(test, tileT.getBottomInset(1));
	}
	
	//Z
	
	@Test
	public void testZGetBaseColor() {
		Color test;
		test = new Color(BoardPanel.COLOR_MAX, BoardPanel.COLOR_MIN, BoardPanel.COLOR_MIN);
		Assert.assertEquals(tileZ.getBaseColor(), test);
	}
	
	@Test
	public void testZGetLightColor() {
		Color test;
		test = tileZ.getBaseColor().brighter();
		Assert.assertEquals(test, tileZ.getLightColor());
	}
	
	@Test
	public void testZGetDarkColor() {
		Color test;
		test = tileZ.getBaseColor().darker();
		Assert.assertEquals(test, tileZ.getDarkColor());
	}
	
	@Test
	public void testZGetDimension() {
		int test;
		test = tileZ.getDimension();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testZGetSpawnColumn() {
		int test;
		test = 5 - (tileZ.getDimension() >> 1);
		Assert.assertEquals(test, tileZ.getSpawnColumn());
	}
	
	@Test
	public void testZGetSpawnRow() {
		int test;
		test = tileZ.getTopInset(0);
		Assert.assertEquals(test, tileZ.getSpawnRow());
	}
	
	@Test
	public void testZGetRows() {
		int test;
		test = tileZ.getRows();
		Assert.assertEquals(2, test);
	}
	
	@Test
	public void testZGetCols() {
		int test;
		test = tileZ.getCols();
		Assert.assertEquals(3, test);
	}
	
	@Test
	public void testZIsTileT() {
		Assert.assertTrue(tileZ.isTile(1,1,0));
	}
	
	@Test
	public void testZIsTileF() {
		Assert.assertFalse(tileZ.isTile(0, 0, 1));
	}
	
	@Test
	public void testZGetLeftInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileZ.getLeftInset(1));
	}
	
	@Test
	public void testZGetRightInset() {
		int test;
		test = 1;
		Assert.assertEquals(test, tileZ.getRightInset(1));
	}
	
	@Test
	public void testZGetTopInset() {
		int test = 0;
		Assert.assertEquals(test, tileZ.getTopInset(1));
	}
	
	@Test
	public void testZgetBottomInset() {
		int test = 1;
		Assert.assertEquals(test, tileZ.getBottomInset(1));
	}
}