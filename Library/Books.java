package LibPckage;

import java.io.Serializable;

public class Books extends Items implements Serializable
{
	private static final long serialVersionUID = 1L;
	boolean fiction;

	public Books(String t, String n, boolean fiction) {
		super(t, n);
		this.fiction = fiction;
		this.type = "BOOK";
	}
	
	
	
}
