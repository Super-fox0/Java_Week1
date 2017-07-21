package javaWork;
import java.io.Serializable;

public class Human implements Serializable
{

	private static final long serialVersionUID = 1L;
	String name;
	String occupation;
	int age;
	
	public Human(String n, String o, int a)
	{
		this.name = n;
		this.occupation = o;
		this.age = a;
	}
	
	public String toString()
	{
		return name + " " + occupation + " " + age;
	}
}
