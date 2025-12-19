package c.austris;

public class WheelType {

	// Attributes
	String material, brakes, tyreType;
	int size;
	
	// Constructor
	public WheelType
			(String material, String brakes, String tyreType,
			int size)
	{
		this.material = material; //material duh
		this.brakes = brakes; //what kinda brakes are in the wheels
		this.tyreType = tyreType; //the kinda tyres are on (racing slicks, hard, soft, that kinda sort)
		this.size = size; //wheel size in inch diameter.
	}
}

