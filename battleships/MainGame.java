package battleships;


public class MainGame 
{
	String[][] gameBoard;
	int boardSize;
	
	int[] takenPlaces;
	
	int xcoord;
	int ycoord;
	
	
	
	public static void main(String[] args)
	{
		
		MainGame x = new MainGame();
		
		x.initGame(3);
		x.resetBoard();
		System.out.println();
		x.populateBoard(1, "verticle", 0, 2);
		x.printBoard();
		x.resetBoard();
		x.populateBoard(2, "verticle", 0, 2);
		x.printBoard();
		x.resetBoard();
		x.populateBoard(3, "verticle", 0, 2);
		x.printBoard();
		x.resetBoard();
		x.populateBoard(1, "horizontal", 0, 2);
		x.printBoard();
		x.resetBoard();
		x.populateBoard(2, "horizontal", 0, 2);
		x.printBoard();
		x.resetBoard();
		x.populateBoard(3, "horizontal", 0, 2);
		x.printBoard();
		x.resetBoard();
		
	}
	
	public void printBoard()
	{
		for (int i = 0; i < gameBoard.length; i++) 
		{
		    for (int j = 0; j <gameBoard[i].length; j++) 
		    {
		        System.out.print(gameBoard[i][j] + " ");
		    }
		    System.out.println(" ");
		}	
	}
	
	public void initGame(int boardSize)
	{
		this.gameBoard= new String[boardSize][boardSize];
		this.boardSize = boardSize;
	}
	
	public void resetBoard()
	{
		for (int i = 0; i < gameBoard.length; i++) 
		{
		    for (int j = 0; j <gameBoard[i].length; j++) 
		    {
		    	gameBoard[i][j] = "~";
		        //System.out.print(gameBoard[i][j] + " ");
		    }
		    System.out.println();
		}	
	}
	
	
	public void populateBoard(int shipSize, String direction, int x, int y)
	{ // Y is left, X is right
		xcoord = x;
		ycoord = y;
	 // int size = shipSize;
		
		if(direction == "verticle")
		{
			gameBoard[ycoord][xcoord] = "#";
			for(int i = 0; i < shipSize; i++)
			{
				if(i >= 1)
				{
					gameBoard[y-i][x] = "#";
				}
			}
		}
		
		else if (direction == "horizontal")
		{
			gameBoard[ycoord][xcoord] = "#";
			for(int i = 0; i < shipSize; i++)
			{
				if(i >= 1)
				{
					gameBoard[y][x+i] = "#";
				}	
			}
		}
	}
	
	public void collisionCheck()
	{
		if(gameBoard[ycoord][xcoord].contains("~") == true)
		{
			//finish method - check ship size and direction
			//update x and y coord and run check to see if free
			//if all evaluate to true then place a ship using populate method
		}
	}
	
}
