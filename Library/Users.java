package LibPckage;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable
{

	private static final long serialVersionUID = 1L;
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
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String print()
	{
		String s = " " + id + " " + name + " "; 
		return s;
	}

}
