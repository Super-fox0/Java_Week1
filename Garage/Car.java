package javaWork;

public class Car extends Vehicle {

	boolean isSportsCar;
	boolean isModified;
	
	public Car(int t, int d, String f, boolean isSportsCar, boolean isModified) 
	{
		super(t, d, f);
		this.isSportsCar = isSportsCar;
		this.isModified = isModified;
		this.type = "CAR";
	}

	public String toString() {
		return "Car [isSportsCar=" + isSportsCar + ", isModified=" + isModified + ", tyreCount=" + tyreCount
				+ ", doorNumber=" + doorNumber + ", fuelType=" + fuelType + ", type=" + type + ", id=" + id + "]";
	}

	public boolean isSportsCar() {
		return isSportsCar;
	}

	public boolean isModified() {
		return isModified;
	}

	public int calculateBill()
	{
		int cost = 100;				
		if(isSportsCar() == true)
		{
			cost = cost + 100;
		}
		if(isModified == true)
		{
			cost = cost + 100;
		}
		return cost ;
	}


	

}
