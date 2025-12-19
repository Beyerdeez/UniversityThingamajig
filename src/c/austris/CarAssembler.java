package c.austris;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CarAssembler {
	// Attributes
				String model, material, engineType, gearboxType, wheelType, insured;
				int year;
				
				// Constructor
				public CarAssembler
						(String material,
						String engineType,
						String gearboxType,
						String wheelType,
						String model, 
						String insured, 
						int year)
				{
					this.material = material;
					this.engineType = engineType;
					this.gearboxType = gearboxType;
					this.wheelType = wheelType;
					this.year = year;
					this.model = model;
					this.insured = insured;
					
				}
				
				
}

				

		