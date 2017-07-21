package LibPckage;

import java.util.ArrayList;

public class Library implements Interface
{
	
	public ArrayList<Items> database = new ArrayList<Items>();
	public ArrayList<Users> userList = new ArrayList<Users>();
	

	public static void main(String[] args) 
	{

		Library l = new Library();
		l.addItem("BOOK", "BOOK1", true);
		l.addItem("MAPS", "MAP1", "LONDON");
		l.print();
		
		
	}

	@Override
	public void checkoutItem() 
	{

		
	}

	@Override
	public void checkinItem() 
	{

		
	}

	@Override
	public void addItem(String type, String name, boolean fic) 
	{
		Books x = new Books(type, name, fic);
		database.add(x);
	}
	
	@Override
	public void addItem(String type, String name, String loc) 
	{
		Maps x = new Maps(type, name, loc);
		database.add(x);
	}
	
	@Override
	public void addItem(String type, String name, int i) 
	{
		Magazines x = new Magazines(type, name, i);
		database.add(x);
	}
	
	public void print()
	{
		String s= "";
		for(Items x : database)
		{
			s = x.name +" "+ x.type + " " + x.id;
			System.out.println(s);
		}	
	}

	@Override
	public void removeItem(int i) 
	{
		for (Items x : database)
		{
			if(x.id == i)
			{
				database.remove(x);
				System.out.println("item " + i + " removed" );
			}
		}
	}

	@Override
	public void updateItem(int i, String nam, String newName) 
	{
		for(Items x : database)
		{
			if(x.id == i && x.name == nam)
			{
				x.updateName(newName);
			}
		}
	}

	@Override
	public void registerPerson(int id, String name) 
	{
		Users x = new Users(id, name);
		userList.add(x);	
	}

	@Override
	public void deletePerson(int id, String name) 
	{
		for(Users u : userList)
		{
			if(u.getName() == name && u.getId() == id)
			{
				userList.remove(u);
			}
		}
	}

	@Override
	public void updatePerson() 
	{

		
	}
	

}
