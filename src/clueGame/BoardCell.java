package clueGame;

import java.util.*;

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
		
	}
}
