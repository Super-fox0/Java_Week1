package javaWork;

public class Motorcycle extends Vehicle {

	int engineSize;

	public Motorcycle(int t, int d, String f,  int engineSize) {
		super(t, d, f);
		this.engineSize = engineSize;
		this.type = "MOTORCYCLE";
	}

	public String toString() {
		return "Motorcycle [engineSize=" + engineSize + ", tyreCount=" + tyreCount + ", doorNumber=" + doorNumber
				+ ", fuelType=" + fuelType + ", type=" + type + ", id=" + id + "]";
	}

	public int getEngineSize() {
		return engineSize;
	}

	public int calculateBill()
	{
		int cost = 50;		
		cost = engineSize + cost;
		return cost ;
	}
}
