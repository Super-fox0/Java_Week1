package battleships;

import java.util.Scanner;

public class MainGame 
{
	String[][] gameBoard;
	int boardSize;
	
	int[] takenPlaces;
	
	int xcoord;
	int ycoord;
	
	boolean occupied = false;
	
	int lives = 0;
	boolean hit = false;
	static boolean gameOver = false;

	
	public static void main(String[] args)
	{
		
		MainGame p1 = new MainGame();
		MainGame p2 = new MainGame();
		
		p1.initGame(5);
		p1.resetBoard();
		
		p2.initGame(5);
		p2.resetBoard();
		
		Scanner scan = new Scanner(System.in);
		
		
		
		//p1 needs to populate
		//p2 needs to populate
		System.out.println();
		p1.populateBoard(2, "horizontal", 0, 1);
		p1.printBoard();
		
		System.out.println();
		p1.populateBoard(2, "verticle", 3, 3);
		p1.printBoard();
		
		
		System.out.println();
		p2.populateBoard(3, "horizontal", 0, 4);
		p2.printBoard();
		
		System.out.println();
		p2.populateBoard(3, "verticle", 4, 4);
		p2.printBoard();
		
		//take turns if hit is true

		
		do
		{
			p1.shoot(scan.nextInt(), scan.nextInt());
			p1.printBoard();
			p1.checkGameOverLives();
//			if(p1.hit == true)
//			{
//				p1.shootAgain(scan.nextInt(), scan.nextInt());			
//			}

			
//			p2.shoot(1, 1);
//			if(p2.hit == true)
//			{
//				p2.shootAgain(1, 2);
//			}

			
		}
		while(gameOver == false);
		

		
		
	}
	
	public void printBoard() // works
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
	
	public void initGame(int boardSize) // works
	{
		this.gameBoard= new String[boardSize][boardSize];
		this.boardSize = boardSize;
	}
	
	public void resetBoard() // works
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
	
	public void populateBoard(int shipSize, String direction, int x, int y) // works
	{ // Y is left, X is right
		xcoord = x;
		ycoord = y;
		lives = lives + shipSize;
	 // int size = shipSize;
		
		if(collisionCheck(y, x, shipSize, direction) == false)
		{
			if(direction == "verticle")
			{
				if(y-shipSize+1 <0 )
				{
					System.out.println("too close to the top edge of map");
				}
				else
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
			}
			
			else if (direction == "horizontal")
			{
				if(x+shipSize > boardSize )
				{
					System.out.println("too close to the right edge of map");
				}
				else
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
		}
	}
	
	public boolean collisionCheck(int yco, int xco, int size, String direction) // works
	{
		
		//if(gameBoard[ycoord][xcoord].contains("~") == true)
		//{
			//finish method - check ship size and direction
			//update x and y coord and run check to see if free
			//if all evaluate to true then place a ship using populate method
			if(direction == "verticle")
			{
				for(int i = 0; i < size; i++)
				{
					if(gameBoard[yco-i][xco] == "#")
					{
						occupied = true;
					}
				}
			}
			else if(direction == "horizontal")
			{
				for(int i = 0; i < size; i++)
				{
					if(gameBoard[yco][xco+i] == "#")
					{
						occupied = true;
					}
				}
			}
		//}
			
			if(occupied == true)
			{
				System.out.println("current posistions taken, select a new one");
			}		
			return occupied;
	}
	
	public void shoot(int x, int y) // works
	{

		if(gameBoard[y][x] == "#")
		{
			gameBoard[y][x] = "*";
			lives = lives -1;
			hit = true;
		}
		else
		{
			gameBoard[y][x] = "M";
			hit = false;
			//miss
			//p2 turn
		}
	}
	
	public void shootAgain(int x, int y) // fucked
	{
		while(hit == true)
		{
			shoot(x, y);
			printBoard();
		}
	}
		
	public boolean checkGameOver() //loop version - fucked
	{
		for (int i = 0; i < gameBoard.length; i++) 
		{
		    for (int j = 0; j <gameBoard[i].length; j++) 
		    {
		        if(gameBoard[i][j] == "#" )
		        {
		        	gameOver = false;

		        }  
		    }
		}	
		if(gameOver == true)
		{
        	System.out.println("Game Over");
		}
		return gameOver;
	}
	
	public boolean checkGameOverLives() // score version - works
	{
		if(lives == 0)
		{
			gameOver = true;
		}
		if(gameOver == true)
		{
			System.out.println("Game Over");
		}
		return gameOver;
	}
	
}


//two boards per player
//1 populated
//1 blank
//
//players take turns shooting
//if hit they get another rurn
//
//if they miss it's next players turn
//
//cycle through this till a gameover is reached
//
//gameover is decided by lives - specific to player
//
//
//shooting method needs to act upon other players board - need to change it
//
//
//main operation is held within a loop
//
//p1.shoot
//
//do(
//if hit == true, p1.shoot
//if hit == false, p2.shoot
//
//if hit == true, then p2.shoot
//while gameover == false
