package tests; 

import java.util.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

//import the other two classes 
import experiment.TestBoard;
import experiment.TestBoardCell; 

public class BoardTestsExp {
	TestBoard board = new TestBoard(); 
	
	@BeforeEach //run before each test
	public void setUp() {
		board = new TestBoard();
	}
	
	//test the creation of adjacency lists
	@Test
	public void testAdjacencyTopLeft() { //[0][0]
		TestBoardCell cell = board.getCell(0,0);
		Set<TestBoardCell> testList = cell.getAdjList();
		assertTrue(testList.contains(board.getCell(1,0)));
		assertTrue(testList.contains(board.getCell(0,1)));	
	}
	@Test
	public void testAdjacencyBottomRight() { //[3][3]
		TestBoardCell cell = board.getCell(3,3);
		Set<TestBoardCell> testList = cell.getAdjList();
		assertTrue(testList.contains(board.getCell(2,3)));
		assertTrue(testList.contains(board.getCell(3,2)));	
	}
	@Test
	public void testAdjacencyTopRight() { //[1][3]
		TestBoardCell cell = board.getCell(1,3);
		Set<TestBoardCell> testList = cell.getAdjList();

		assertTrue(testList.contains(board.getCell(0,3)));
		assertTrue(testList.contains(board.getCell(2,3)));	
		assertTrue(testList.contains(board.getCell(1,2)));	
	}
	@Test 
	public void testAdjacencyBottomLeft() { //[3][0]
		TestBoardCell cell = board.getCell(3,0); 
		Set<TestBoardCell> testList = cell.getAdjList();

		assertTrue(testList.contains(board.getCell(2,0)));
		assertTrue(testList.contains(board.getCell(3,1)));	
	}
	

	
	
	//test target creation for 4x4 board
	@Test
	public void testTargets() {
		TestBoardCell startCell = board.getCell(0,0);
		board.calcTargets(startCell, 3);
		Set<TestBoardCell> targets = board.getTargets();

		assertTrue(targets.contains(board.getCell(3, 0)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(0, 3)));
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(0, 1)));		
	}

	@Test
	public void testTargetsOccupied(){
		board.getCell(0,2).setOccupied(true);

		TestBoardCell startCell = board.getCell(0,3);
		board.calcTargets(startCell, 3);
		Set<TestBoardCell> targets = board.getTargets();

		assertFalse(targets.contains(board.getCell(0, 2)));
		//assertTrue(targets.contains(board.getCell(2, 3)));
		//assertTrue(targets.contains(board.getCell(3, 2)));
	}

	@Test
	public void testTargetsRoom(){
		board.getCell(1,2).setRoom(true);

		TestBoardCell startCell = board.getCell(0,3);
		board.calcTargets(startCell, 3);
		Set<TestBoardCell> targets = board.getTargets();

		assertTrue(targets.contains(board.getCell(1, 2)));
		//assertTrue(targets.contains(board.getCell(2, 3)));
		//assertTrue(targets.contains(board.getCell(3, 2)));
		//assertTrue(targets.contains(board.getCell(0, 1)));
	}
}
