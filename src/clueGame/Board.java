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
    //THIS MIGHT NOT BE THE BEST IDEA BUT IT'S WORKING SO FAR -- MIGHT NEED TO CHANGE FOR A TRY CATCH
	public void initialize() throws BadConfigFormatException, FileNotFoundException {
		loadLayoutConfig();
	}
	public void loadSetupConfig() throws FileNotFoundException{
		roomMap = new HashMap<>();
		
		Scanner scanner = new Scanner(new File(setupConfigFiles));
		
		while (scanner.hasNextLine()){
			String line = scanner.nextLine().trim();
			
			String[] parts = line.split(",");
			
			//whenever we dont have three eventually an exception
			
			String type = parts[0].trim();
			String name = parts[1].trim();
			String symbol = parts[2].trim();
			
			char initial = symbol.charAt(0);
			roomMap.put(initial, new Room (name, null, null));
		}
		scanner.close();
		
	}
	public void loadLayoutConfig() throws FileNotFoundException {
		ArrayList<String[]> fileLines = new ArrayList<>();
		Scanner scanner = new Scanner(new File(layoutConfigFiles));
		
		int expectedColumns = -1; 
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			String[] parts = line.split(",");
			
			if (expectedColumns == -1) {
				expectedColumns = parts.length;
			} else  if (parts.length != expectedColumns){
				scanner.close();
				//WE MIGHT WANT TO THROW AN EXCPETION HERE 
			}
			fileLines.add(parts);
			
		}
		scanner.close();
		
		numRows = fileLines.size();
		numColumns = expectedColumns;
		
		grid = new BoardCell[numRows][numColumns];
		for (int row = 0; row < numRows; row++) {
			String[] currentRow = fileLines.get(row);
			
			for (int col = 0; col < numColumns; col++) {
				String cellCode = currentRow[col].trim();
				
				//each cell must be length  1 or 2 n
				if (cellCode.length() < 1 || cellCode.length() > 2) {
					//Throw exception
				}
				char initial = cellCode.charAt(0);
				BoardCell cell = new BoardCell(row,col,initial);
				
				//special cases
				if (cellCode.length() == 2) {
					char marker = cellCode.charAt(1);
					
					if (marker == '<') {
						cell.setDoorDirection(DoorDirection.LEFT);
					}else if (marker == '>') {
						cell.setDoorDirection(DoorDirection.RIGHT);
					}else if (marker == '^') {
						cell.setDoorDirection(DoorDirection.UP);
					}else if (marker == 'v') {
						cell.setDoorDirection(DoorDirection.DOWN);
					}else if (marker == '*') {
						cell.setLabel(true);
						roomMap.get(initial).setLabelCell(cell);
					}else if (marker == '#') {
						cell.setLabel(true);
						roomMap.get(initial).setLabelCell(cell);
					}else if (marker == '>') {
						cell.setDoorDirection(DoorDirection.RIGHT);
					}else if (marker == 'D') {
						cell.setSecretPassage('G');
					}else if (marker == 'G') {
						cell.setSecretPassage('D');
					}else if (marker == 'P') {
						cell.setSecretPassage('M');
					}else if (marker == 'M') {
						cell.setSecretPassage('P');
					}
				}
				grid[row][col] = cell;
			}
		}
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
