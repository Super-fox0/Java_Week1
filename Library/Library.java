package LibPckage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Interface, Serializable
{

	private static final long serialVersionUID = 1L;
	public ArrayList<Items> database = new ArrayList<Items>();
	public ArrayList<Users> userList = new ArrayList<Users>();
	

	public static void main(String[] args) 
	{

		Library l = new Library();
		l.addItem("BOOK", "BOOK1", true);
		l.addItem("MAPS", "MAP1", "LONDON");
		l.print();
		l.registerPerson(1, "John");
		l.updatePerson(1, "NEWJOHN");
		
		l.checkoutItem(0, 0);
		l.checkinItem(0, 0);
		
		l.writeToFile(l);
		l.readFromFile();
		
	}

	@Override
	public void checkoutItem(int userIndex, int itemId) 
	{
		Users u = userList.get(userIndex);
		
		for (Items x : database)
		{
			if(x.id == itemId)
			{
				u.itemList.add(x);
				System.out.println("Item checked out " + x.getName() + " By User: " + u.id + " " +u.getName());
			}
		}
	}

	@Override
	public void checkinItem(int userIndex, int itemId) 
	{
		Users u = userList.get(userIndex);
		//System.out.println(u.itemList.toString());
		
		for (Items x : database)
		{
			if(x.id == itemId)
			{
				u.itemList.remove(x);
				System.out.println("Item checked in " + x.getName() + " By User: " + u.id + " " +u.getName());
				//System.out.println(u.itemList.toString());
			}
		}
		
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
	public void updatePerson(int i, String name) //select user by ID - update name
	{

		for(Users u : userList)
		{
			//System.out.println(u.print());
			u.getId();
			if(u.getId() == i)
			{
				u.setName(name);
				//System.out.println("Name Updated" + userList.get(0).print());
			}
		}
		
	}
	
	public void writeToFile(Library l)
	{
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try 
		{
			fout = new FileOutputStream("c:\\test\\libraryTest.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(l);
			System.out.println("Library wrote to file");
		} 
		
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
		
		finally 
		{
			if (fout != null) 
			{
				try 
				{
					fout.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}

			if (oos != null) 
			{
				try 
				{
					oos.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readFromFile() 
	{
		Library l = new Library();
		
		try
		{
			FileInputStream fis = new FileInputStream("c:\\test\\libraryTest.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			 l = (Library) ois.readObject();
			 ois.close();
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Library read from file");
			l.print();		
		}
	}

	
	
}
