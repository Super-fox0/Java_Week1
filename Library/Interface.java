package LibPckage;

public interface Interface 
{

	
	void removeItem(int i);

	void addItem(String type, String name, boolean fic);

	void addItem(String type, String name, String loc);

	void addItem(String type, String name, int i);

	void registerPerson(int id, String name);

	void deletePerson(int id, String name);

	void updateItem(int i, String nam, String newName);

	void updatePerson(int i, String name);

	void checkoutItem(int userIndex, int itemId);

	void checkinItem(int userIndex, int itemId);
	
}
