package c.austris;

public class EngineType {

	// Attributes
	String name, type;
	int cylinders;
	double volume;
	
	// Constructor
	public EngineType
			(String name, String type,
			int cylinders, double volume)
	{
		this.name = name; //engine name
		this.type = type; //engine type (aka inline 3 or v8 or that jazz)
		this.cylinders = cylinders;
		this.volume = volume; //engine size in litres
	}
	
	
}
