package experiment;

import java.util.*;

public class TestBoard {

	private TestBoardCell[][] grid;
	private Set<TestBoardCell> targets;
	private Set<TestBoardCell> visited;
	
	final static int ROWS = 4;
	final static int COLS = 4;
	
	public TestBoard() {
		grid = new TestBoardCell[ROWS][COLS];
		targets = new HashSet<TestBoardCell>();
		visited = new HashSet<TestBoardCell>();
		
		//4x4
		for (int row = 0; row < ROWS; row++){
			for (int col = 0; col < COLS; col++){
				grid[row][col] = new TestBoardCell(row, col);
			}
		}
		calcAdjacencies();
	}

	private void calcAdjacencies() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				TestBoardCell cell = grid[row][col];
				if (row > 0) {
					cell.addAdjacency(grid[row - 1][col]);
				}

				if (row < ROWS - 1) {
					cell.addAdjacency(grid[row + 1][col]);
				}

				if (col > 0) {
					cell.addAdjacency(grid[row][col - 1]);
				}

				if (col < COLS - 1) {
					cell.addAdjacency(grid[row][col + 1]);
				}
			}
		}
	}

	private void finaAllTargets(TestBoardCell thisCell, int numSteps) {
		Set<TestBoardCell> aList = thisCell.getAdjList();
		for(TestBoardCell cell : aList) {
			//check adj
			if(visited.contains(cell)){
				continue;
			}
			
			else if(cell.getOccupied()) {
				continue;
			}
			
			visited.add(cell);
			
			//check if on room
			if(cell.isRoom()) {	
				targets.add(cell);
			}
			
			else if(numSteps == 1) {
				targets.add(cell);
			}
			
			else {
				finaAllTargets(cell, (numSteps-1));
			}
			visited.remove(cell);
		}
	}
	
	public void calcTargets( TestBoardCell startCell, int pathLength) {
		targets = new HashSet<TestBoardCell>();
		
		//ensure clear start
		targets.clear();
		visited.clear();
		
		//add string to targets
		visited.add(startCell);
		
		finaAllTargets(startCell, pathLength);
		
	}
	
	public TestBoardCell getCell( int row, int col ) {
		return grid[row][col];
	}
	
	public Set<TestBoardCell> getTargets(){
		return targets;
	}
	
}
