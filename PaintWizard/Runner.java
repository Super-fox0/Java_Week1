package javaWork;

public class Runner {

	public static void main(String[] args) 
	{

		PaintWizard x = new PaintWizard();
		System.out.println(x.leastWaste(1000) + "L");
		System.out.println("");
		System.out.println("cheapest: £" + x.priceGet() + " " + x.type);
	}

}
