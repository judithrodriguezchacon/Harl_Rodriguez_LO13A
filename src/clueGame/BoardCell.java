package clueGame;

import java.util.*;


public class BoardCell {
	
	private int row;
	private int col;
	char initial;
	
	private DoorDirection doorDirection;
	private boolean roomLabel;
	private boolean roomCenter;
	private char secretPassage;
	
	private boolean isDoor;
	
	private Set<BoardCell> adjList;
	
	public BoardCell(int row, int col, char initial, DoorDirection doorDirection, boolean roomLabel, boolean roomCenter, char secretPassage, Set<BoardCell> adjList) {
		super();
		this.row = row;
		this.col = col;
		this.initial = initial;
		this.doorDirection = doorDirection;
		this.roomLabel = roomLabel;
		this.roomCenter = roomCenter;
		this.secretPassage = secretPassage;
		this.adjList = adjList;
	}
	
	
	public void addAdj(BoardCell adj) {
		adjList.add(adj);
	}
	
	public Set<BoardCell> getAdjList(){
		return adjList; 
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public char getInitial() {
		return initial;
	}
		
	public boolean isDoorway() {
		return isDoor;  //FIX THIS
	}
	
	public void setDoorDirection(DoorDirection doorDirection) {
		this.doorDirection = doorDirection; 
	} 
	
	public DoorDirection getDoorDirection() {
	    return doorDirection;
	}

	
	public boolean isLabel() {
		return roomLabel;
	}
	
	public void setLabel(boolean roomLabel) {
		this.roomLabel = roomLabel;
	}
	
	
	public boolean isRoomCenter() {
		return roomCenter;
	}
	
	private void setRoomCenter(boolean roomCenter) {
		this.roomCenter = roomCenter;
	}
	
	public char getSecretPassage() {
		return secretPassage;
	
	}
	
	public void setSecretPassage(char secretPasage) {
		this.secretPassage = secretPasage;
	}
	
	
}



































