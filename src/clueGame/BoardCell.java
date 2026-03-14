package clueGame;

import java.util.*;

import experiment.TestBoardCell;

public class BoardCell {
	private int row;
	private int col;
	char initial;
	
	DoorDirection doorDirection;
	private boolean roomLabel;
	private boolean roomCenter;
	private char secretPassage;
	
	
	private Set<BoardCell> adjList;
	
	public void addAdj(BoardCell adj) {
		adjList.add(adj);
	}
	
	public Set<BoardCell> getAdjList(){
		return adjList; 
	}
	
	private boolean roomLabel() {
		return roomLabel;
	}
	
	private boolean roomCenter() {
		return roomCenter;
	}
	
	private char secretPassage() {
		return secretPassage;
	}
	//ALL THE BELOW ARE JUST PLACE HOLDER I NEED TO ACTUALLY IMPLEMENT THE FOLLOWING
	public boolean isDoorway() {
		return false; //place holder to run tests
	}
	public boolean getDoorDirection() {
		return false; //place holder to run tests
	} 
	public boolean isLabel() {
		return false;
	}
	public boolean isRoomCenter() {
		return false;
	}
	public BoardCell getLabelCell() {
		return null;
	}
	public BoardCell getSecretPassage() {
		return null;
	}
	
	
	
	
	
	
	
	
	
}

