package javaWork;

public class Van extends Vehicle {

	int height;
	int length;
	
	public Van(int t, int d, String f ,int height, int length) {
		super(t, d, f);
		this.height = height;
		this.length = length;
		this.type = "VAN";
	}

	public String toString() {
		return "Van [height=" + height + ", length=" + length + ", tyreCount=" + tyreCount + ", doorNumber="
				+ doorNumber + ", fuelType=" + fuelType + ", type=" + type + ", id=" + id + "]";
	}

	public int getHeight() {
		return height;
	}

	public int getLength() {
		return length;
	}

	public int calculateBill()
	{
		int cost = 200;		
		cost = height*length + cost;
		return cost ;
	}

}
