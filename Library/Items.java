package LibPckage;

import java.io.Serializable;

public abstract class Items implements Serializable
{

	private static final long serialVersionUID = 1L;
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
	
	public String getName()
	{
		return name;
	}
}
