package LibPckage;

public abstract class Items 
{
	static int staticId = 0;
	public int id = 0;
	public String type;
	public String name;
	
	
	public Items(String t, String n)
	{
		type = t;
		name = n;
		this.id = staticId;
		Items.staticId = staticId + 1;
	}
	
	public void updateName(String x)
	{
		name = x;
	}
	
}
