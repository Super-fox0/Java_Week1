package LibPckage;

import java.io.Serializable;

public class Maps extends Items implements Serializable
{

	private static final long serialVersionUID = 1L;
	String location;

	public Maps(String s, String t, String location) {
		super(s, t);
		this.location = location;
		this.type = "MAPS";
	}
	
	
	
}
