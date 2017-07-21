package javaWork;
import java.util.ArrayList;

public class Garage {

	static Vehicle[] vehicleArray = new Vehicle[3];
	static ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
	
	public static void main(String[] args) 
	{
		
	//	Car c1 = new Car(4, 4, "petrol", true, true);
	//	Van v1 = new Van(4,2,"Diesel",10,10);
	//	Motorcycle m1 = new Motorcycle(2,0,"petrol",100);
		
	//	System.out.println(c1.toString());
	//	System.out.println(v1.toString());
	//	System.out.println(m1.toString());
		
		//vehicleArray[0] = c1;
	//	vehicleArray[1] = v1;
		//vehicleArray[2] = m1;
	
	//	System.out.println("");
		
	//	for(Vehicle i : vehicleArray)
	//	{
	//		System.out.println("");
	//		System.out.println(i.toString());
	//		System.out.println(i.calculateBill());
	//		System.out.println("");
	//	}
		
		addVehicle(1,1,"petrol", true, true);	 	//add a car
		System.out.println(Vehicles.toString());
		System.out.println("");
		removeVehicle(0);							//remove car from position 0
		System.out.println(Vehicles.toString());	//print
		
		addVehicle(4,2,"diesel",10,10);				//add Van
		System.out.println(Vehicles.toString());
		addVehicle(1,1,"petrol", true, true);		//add Car
		System.out.println("");						//print
		
		removeVehicle("VAN");						//remove Van
		System.out.println(Vehicles.toString());
		System.out.println("");
		
		addVehicle(2,0,"petrol",100);				//add Motorcycle
		System.out.println("");
		System.out.println(Vehicles.toString());	//print
		
		emptyGarage();								//clear garage
		System.out.println(Vehicles.toString());	//print
		
	}

	
	public static void addVehicle(int t, int d, String f, boolean isSportsCar, boolean isModified)
	{
		Vehicle x = new Car(t,d,f, isSportsCar, isModified);
		 Vehicles.add(x);
	}
	
	public static void addVehicle(int t, int d, String f ,int height, int length)
	{
		Vehicle x = new Van(t,d,f, height, length);
		Vehicles.add(x);
	}
	
	public static void addVehicle(int t, int d, String f,  int engineSize)
	{
		Vehicle x = new Motorcycle(t,d,f, engineSize);
		Vehicles.add(x);
	}
	
	public static void removeVehicle(int i)
	{
		Vehicles.remove(i);
	}
	
	public static void removeVehicle(String type)
	{
		
		for(Vehicle i : Vehicles)
		{
			if (i.getType() == type)
			{
				Vehicles.remove(i);
			}
		}
	}
	
	public static void emptyGarage()
	{
		Vehicles.clear();
	}
	
	
}
