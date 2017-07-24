package LibPckage;

import java.io.Serializable;

public class Magazines extends Items implements Serializable
{

	private static final long serialVersionUID = 1L;
	int issue;

	public Magazines(String s, String t, int i) 
	{
		super(s, t);
		this.issue = i;
		this.type = "MAGAZINES";
	}
	
	
	
}
