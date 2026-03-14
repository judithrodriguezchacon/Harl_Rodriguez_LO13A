package clueGame;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {
	private BoardCell[][] grid;
	private int numRows;
	private int numColumns;
	private String layoutConfigFiles;
	private String setupConfigFiles;
	private Map<Character, Room> roomMap;
	private static Board theInstance = new Board();
	
	
	
	//singleton style constructor

    // constructor is private to ensure only one can be created
    private Board() {
           super() ;
    }
    // this method returns the only Board
    public static Board getInstance() {
           return theInstance;
    }
    
    /*
     * initialize the board (since we are using singleton pattern)
     */
	public void initialize() {
		try {
			loadSetupConfig();
			loadLayoutConfig();
		}
		catch(BadConfigFormatException e){
			System.out.println(e);
		}
	}
<<<<<<< HEAD
	
	public void loadSetupConfig() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("setupConfigFiles"));
=======

	public void loadSetupConfig() {
		
>>>>>>> faa7566719ba661a3360c831a291499322e31641
	}
	
	public void loadLayoutConfig() {
		Scanner scanner = new Scanner(new File("layoutConfigFiles"));
	}

	public void setConfigFiles(String setupConfigFiles, String layoutConfigFiles) {
		this.setupConfigFiles = setupConfigFiles;
		this.layoutConfigFiles = layoutConfigFiles;
	}

	
	public Room getRoom(char initial) {
	    return roomMap.get(initial);
	}

	public Room getRoom(BoardCell cell) {
	    return roomMap.get(cell.getInitial());
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
