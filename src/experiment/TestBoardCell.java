package experiment;
import java.util.*;


public class TestBoardCell {
	private int row;
	private int col;
	
	private boolean isRoom; 
	private boolean occupied;

	private Set<TestBoardCell> adjList = new HashSet<TestBoardCell>();  

	public TestBoardCell(int r, int c){
		row = r;
		col = c;
	}

	public void addAdjacency(TestBoardCell cell){
		adjList.add(cell);
	}

	public Set<TestBoardCell> getAdjList(){
		return adjList;
	}

	public void setRoom(boolean t) {
		isRoom = t;
	}
	
	public boolean isRoom() {
		return isRoom;
	}
	
	public void setOccupied(boolean t) {
		occupied = t;
	}
	
	public boolean getOccupied() {
		return occupied;
	}
	
}
	
