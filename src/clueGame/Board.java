package clueGame;

import java.util.*;

public class Board {
	private BoardCell[][] grid;
	private int numRows;
	private int numColumns;
	private String layoutConfigFiles;
	private String setupConfigFiles;
	private Map<Character, Room> roomMap;
	private static Board theInstance;
	
	public void initialize() {
		
	}
	
	public void loadSetupConfig() {
		
	}
	
	public void loadLayoutConfig() {
		
	}

	public void setConfigFiles(String setupConfigFiles, String layoutConfigFiles) {
		this.setupConfigFiles = setupConfigFiles;
		this.layoutConfigFiles = layoutConfigFiles;
	}

	public static Board getInstance() {
		return theInstance;
	}

	public Room getRoom(char name) {
		return roomMap.get(name);
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumColumns() {
		return numColumns;
	}
	
	public BoardCell getCell(int row, int col) {
		return grid[row][col];
	}
	
	
	
	
}
