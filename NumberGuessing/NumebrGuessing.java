package javaWork;
import java.util.Scanner;

public class NumebrGuessing {

	
	int actual = 23;
	int guess = 0;
	
	Scanner scan = new Scanner(System.in);
	String s = "";
	
	public static void main(String[] args) 
	{
	
		NumebrGuessing ng = new NumebrGuessing();
		System.out.println("Guess HIGHER or LOWER: ");
		ng.doGuess();
		
		
	}

	
	
	public void doGuess()
	{
		System.out.println("current guess:" + guess);
		while (actual != guess)
		{
			s = scan.nextLine();
			if(s == "HIGHER")
			{
				guess = guess + 5;
				System.out.println(guess);
			}
			else if(s == "LOWER")
			{
				guess = guess - 1;
				System.out.println(guess);
			}
		}
			System.out.println("correct");
	}
		
}
