package LibPckage;

public interface Interface 
{

	public void checkoutItem();
	
	public void checkinItem();
		
	public void updatePerson();

	void removeItem(int i);

	void addItem(String type, String name, boolean fic);

	void addItem(String type, String name, String loc);

	void addItem(String type, String name, int i);

	void registerPerson(int id, String name);

	void deletePerson(int id, String name);

	void updateItem(int i, String nam, String newName);
	
}
