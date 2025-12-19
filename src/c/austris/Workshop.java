package c.austris;

import java.io.File;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

// import other garbolium
import c.austris.FileManager9000;
import c.austris.CarAssembler;

// setting all defaults

public class Workshop {
	static String stringCheck(String message, String defaulto) {
		String charString;
		
		do {
			charString = JOptionPane.showInputDialog(message, defaulto);
			if(charString == null)
				return null;
			
			charString = charString.trim();
		} while(!Pattern.matches("^[a-zA-ZāčēģīķļņšūžĀČĒĢĪĶĻŅŠŪŽ ]+$", charString));
		
		return charString;
	}
	
	static int numCheck(
		String message, int def, int min, int max) {
		String input;
		int num;
		
		while(true) {
			input = (String)JOptionPane.showInputDialog(null, 
			message, "Data Entry", JOptionPane.INFORMATION_MESSAGE, 
			null, null, def);
			
			if(input == null)
				return -1;
			
			try {
				num = Integer.parseInt(input);
				if(num < min || num > max) {
					JOptionPane.showMessageDialog(null,
					"Incorrect manufacturing year!", "Error lol", 
					JOptionPane.ERROR_MESSAGE);
					continue;
				}
				
				return num;
				
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, 
				"No whole number was entered!", 
				"Incorrect Data", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	static String carSelect(ArrayList<CarAssembler> carList) {
		String all = "";
		for(int i=0; i<carList.size(); i++) {
			all += i+". "+carList.get(i).model+"\n";
		}
		return all;
	}
	
	
	public static void main(String[] args) {
		String mainmenu;
		ArrayList<CarAssembler> carList = new ArrayList<>();
		CarAssembler car = null;
		String[] actions = {"Pull in a car", "Send a car to the junkyard", 
				"Actions", "Save to File", 
				"Read Car List", "STOP"};
		int index;
		
		do {
			mainmenu = (String) JOptionPane.showInputDialog(null, 
			"Choose an action", "Main Menu", 
			JOptionPane.QUESTION_MESSAGE, null, actions, actions[0]);
			index = Arrays.asList(actions).indexOf(mainmenu);
			
			if (index == -1)
				index = 5;
			
			switch(index) {
				case 0:
					String model, engineType, wheelType, material,
					gearboxType, insured = "";
					int year;
					
					model = 
						stringCheck("Enter car model", "Corolla");
					if(model == null)
						break;
					
					material = stringCheck("Enter car's material", "Steel");
					if(material == null)
						break;
					
					engineType = 
						stringCheck("Enter the engine type", "Inline 3");
					if(engineType == null)
						break;
					
					wheelType =
							stringCheck("Enter wheel type", "Hard tyres");
					if(wheelType == null)
						break;
					
					gearboxType =
							stringCheck("Enter gearbox type", "Manual");
					if(gearboxType == null)
						break;
					
					year = numCheck("Enter manufacturing year", 
					Year.now().getValue(), (Year.now().getValue())-100, 
					Year.now().getValue());
					
					String[] varianti = {"Nav siksniņa", "Ir siksniņa"};
					int poga = JOptionPane.showOptionDialog(null, 
						"Is the car insured?", "important question (100% real)", 
						JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, varianti, varianti[0]);
					
					if(poga == -1)
						break;
					
					else if(poga == 0)
						insured = "no";
						
					else
						insured = "yes";
					
					}
					
					CarAssembler newCar = new CarAssembler(model, material, engineType, wheelType,
							gearboxType, year, insured);
					carList.add(newCar);
					break;
		}while(true);
	}
}
					