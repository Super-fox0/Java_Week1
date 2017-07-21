package LibPckage;

public class Books extends Items
{

	boolean fiction;

	public Books(String t, String n, boolean fiction) {
		super(t, n);
		this.fiction = fiction;
		this.type = "BOOK";
	}
	
	
	
}
