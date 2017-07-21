package javaWork;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WorkingFiles 
{

	ArrayList<Human> x = new ArrayList<Human>();

	
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{

		WorkingFiles wf = new WorkingFiles();

		Human h1 = new Human("JOHN1", "PRICK1", 10);
		Human h2 = new Human("JOHN2", "PRICK2", 11);
		Human h3 = new Human("JOHN3", "PRICK3", 12);
		Human h4 = new Human("JOHN4", "PRICK4", 13);
		Human h5 = new Human("JOHN5", "PRICK5", 14);

		wf.x.add(h1);
		wf.x.add(h2);
		wf.x.add(h3);
		wf.x.add(h4);
		wf.x.add(h5);
		
		for(Human hum : wf.x)
		{
			System.out.println(hum.toString());
		}
		System.out.println(" ");
		
		wf.writeToFile(wf.x);
		wf.readFromFile();
		
	}

	
	public void writeToFile(ArrayList<Human> h)
	{
		//for (Human i : wf.x) 
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try 
		{
			fout = new FileOutputStream("c:\\test\\test1.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(x);
			System.out.println("Done");

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
		ArrayList<Human> h = new ArrayList<Human>();
		
		try
		{
			FileInputStream fis = new FileInputStream("c:\\test\\test1.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			 h =  (ArrayList<Human>) ois.readObject();
			 ois.close();
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			for(Human h1 : h)
			{
				System.out.println(h1.toString());
			}
		}
	}
	
}

