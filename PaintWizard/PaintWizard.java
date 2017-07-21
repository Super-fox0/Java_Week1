package javaWork;

public class PaintWizard {
	
	public static void main(String[] args) 
	{
	
	}
	
	//prices for different paints - cheap, average, dulux
		double cheap = 19.99;
		double average = 17.99;
		double dulux = 25;
		double cheapest = 0;
			
	//placeholder for total area		
		int cheapArea = 200;
		int averageArea= 165;
		int duluxArea = 200;
		
		int extended1 = 200;
		int extended2 = 165;
		int extended3 = 200;
		
		String type = "AverageJoes";
		public int roomS = 0;


	
	public double leastWaste(int roomSize)
	{
		roomS = roomSize;
		System.out.println("Room Size:"+ roomSize);
		System.out.println("Default Area covered:" + cheapArea +" "+ averageArea +" " +duluxArea);
		System.out.println("prices: " + cheap + " " + average + " " + dulux);

		
		while(roomSize > extended1)
		{
			extended1 = extended1 + cheapArea;
			cheap = cheap + 19.99;
		}
		while(roomSize > extended2)
		{
			extended2 = extended2 + averageArea;
			average = average + 17.99;
		}
		while(roomSize > extended3)
		{
			extended3 = extended3 + averageArea;
			dulux = dulux + 25;
		}
			
		System.out.println("extended: " + extended1 + " " + extended2 + " " + extended3);
		System.out.println("new prices: " + cheap + " " + average + " " + dulux);
		
		int x = extended1 - roomSize;
		int y = extended2 - roomSize;
		int z = extended3 - roomSize;	
		System.out.println("Wastage:" + x + " " + y + " " + z);
		
		int a = 0;
		System.out.println("Least waste:");
		if(x<y && x<z)
		{
			a=x;
			System.out.println("CheapoMax");
		}
		if(y<x && y<z)
		{
			a=y;
			System.out.println("AverageJoes");
		}
		if(z<x && z<y)
		{
			a=z;
			System.out.println("DuluxourousPaints");
		}
		return a;
	}

	public double priceGet()
	{
		if(cheap < average)
		{
			cheapest = cheap;
			type = "CheapoMax";
		}
		if(cheapest > dulux)
		{
			cheapest = dulux;
			type = "DuluxourousPaints";
		}
		return cheapest;
	}
	
}
	
	
	
	

