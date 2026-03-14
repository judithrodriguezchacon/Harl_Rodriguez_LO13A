package clueGame;

import java.util.*;

public class Room {
	private String name;
	private BoardCell centerCell;
	private BoardCell labelCell;
	
	public Room() {
		
	}
	
	public Room(String name, BoardCell centerCell, BoardCell labelCell) {
		this.name = name;
		this.centerCell = centerCell;
		this.labelCell = labelCell;
	}
	
	public String getName() {
		return name;
	}
	public BoardCell getCenterCell() {
		return centerCell;
	} 
	public BoardCell getLabelCell () {
		return labelCell;
	}
	public void setLabelCell(BoardCell labelCell) {
		this.labelCell = labelCell;
	}

	public void setRoomCenter(BoardCell centerCell) {
		this.centerCell = centerCell;
		
	}

}
