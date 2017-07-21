package LibPckage;

import java.util.ArrayList;

public class Users 
{
	int id;
	String name;
	public ArrayList<Items> itemList = new ArrayList<Items>();
	
	
	public Users(int id, String name ) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
	

}
