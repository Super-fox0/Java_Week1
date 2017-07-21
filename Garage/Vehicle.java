package javaWork;

public abstract class Vehicle {

	int tyreCount;
	int doorNumber;
	String fuelType;
	String type;
	static int idCount = 0;
	int id = 0;
	
	public Vehicle(int t, int d, String f)
	{
		this.tyreCount = t;
		this.doorNumber = d;
		this.fuelType = f;
		this.type = "";
		id = idCount;
		idCount++;
	}
	

	public abstract String toString();
	
	public abstract int calculateBill();
	
	public String getType()
	{
		return this.type;
	}
	


		
}
