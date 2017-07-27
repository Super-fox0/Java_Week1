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
	boolean gameOver = false;

	
	public static void main(String[] args)
	{
		
		MainGame p1 = new MainGame();
		MainGame p2 = new MainGame();
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter board Size: ");
		int s = scan.nextInt();
		
		p1.initGame(s);
		p1.resetBoard();
		
		p2.initGame(s);
		p2.resetBoard();
		
			
		String dir;
		int xpos;
		int ypos;
		
		System.out.println("Player 1 populate your board - direction, x, y");
		System.out.println("place your carrier");

		//p1 populate
		System.out.println("direction:");
		dir = p1.inputS();
		System.out.println("x:");
		xpos = p1.input();
		System.out.println("y:");
		ypos = p1.input();
		p1.populateBoard(5, dir, xpos, ypos);  //fix board population with scanner input for both players
		p1.printBoard();
//		System.out.println("place your destroyer");
//		p1.populateBoard(4, scan.next(), scan.nextInt(), scan.nextInt());
//		System.out.println("Player 1 ship posistions");
//		p1.printBoard();
			
		System.out.println();

		//p2 populate
		p2.populateBoard(3, "horizontal", 0, 4);
		p2.populateBoard(3, "verticle", 4, 4);
		System.out.println("Player 2 ship posistions");
		p2.printBoard();
		
	
		//while loop for turns
		while(p1.gameOver == false && p2.gameOver == false)
		{  //game over has issues- find them
						
			System.out.println("Player 2 turn:");
			p1.shoot(scan.nextInt(), scan.nextInt());
			p1.printBoard();
			if(p1.hit == true)
			{
				System.out.println("player 1 board");
				p1.printBoard();
				p1.shootAgain();		
			}
			
			System.out.println("Player 1 turn:");
			p2.shoot(scan.nextInt(), scan.nextInt());
			p2.printBoard();
			if(p2.hit == true)
			{
				System.out.println("player 2 board");
				p1.printBoard();
				p2.shootAgain();
			}
			
			System.out.println("p1 lives: " + p1.lives);
			System.out.println("p2 lives: " + p2.lives);
					
		}
					
	}
	
	public int input()
	{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		return x;
	}
	
	public String inputS()
	{
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		return x;
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
		lives = lives + shipSize;  // alter how lives work when scanner is implemnted in main - won't have variable lives but a set 20 based on all ships
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
			System.out.println("HIT! take another turn");
			checkGameOverLives();
		}
		else
		{
			gameBoard[y][x] = "M";
			hit = false;
			System.out.println("MISS!");
			System.out.println();
		}
	}
	
	public void shootAgain() // fucked
	{
		while(hit == true)
		{
			int coordx= input();
			int coordy = input();
			
			shoot(coordx, coordy);
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
			System.out.println("Game Over");
		}
		return gameOver;
	}
	
}


