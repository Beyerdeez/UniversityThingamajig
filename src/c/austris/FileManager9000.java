package c.austris;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager9000 {
	//repurposed an old java project of mine

		static Scanner scan = new Scanner(System.in);
		public static void clearScreen() {  
		    System.out.print("\033[H\033[2J");
		    System.out.flush();
		} 
		 private static void pressEnterToContinue()
		 { 
		        System.out.println("Press Enter key to continue...");
		        try
		        {
		            System.in.read();
		        }  
		        catch(Exception e)
		        {}  
		 }
		static void NewPerson() {
			try {
				BufferedWriter data = new BufferedWriter(new FileWriter("carlist.txt",true));
				System.out.println("Your first name:");
				String name = scan.nextLine();
				System.out.println("Your last name:");
				String surname = scan.nextLine();
				System.out.println("Your phone number:");
				String phone = scan.nextLine();
				data.write(name+", "+surname+", "+phone+"\n");
				data.close();
				System.out.print("Data successfully added.\n");
			}catch(IOException e) {
				System.out.println("Problem with file!");
			}
		}
		
		static void ReturnData() {
			try {
				BufferedReader fetch = new BufferedReader(new FileReader("carlist.txt"));
				String data = fetch.readLine();
				while(data != null) {
					System.out.println(data);
					data = fetch.readLine();
				}
				fetch.close();
				System.out.print("Data successfully retrieved.\n");
			}catch(IOException e) {
				System.out.println("Problem with file!");
			}
		}
		static int ReturnAmount() {
			
			try {
				int i = 0;
				BufferedReader fetch = new BufferedReader(new FileReader("carlist.txt"));
				String data = fetch.readLine();
				while(data != null) {
					i++;
					data = fetch.readLine();
				}
				fetch.close();
				return i;
			}catch(IOException e) {
				System.out.println("Problem with file!");
				return 0;
			}
		}
		static void FindMember() {
			try {
				BufferedReader fetch = new BufferedReader(new FileReader("names.txt"));
				System.out.println("Enter the contact's first or last name: ");
				String find = scan.nextLine();
				String row = fetch.readLine();
				String dati1 = find.toLowerCase();
				while(row != null) {
					String dati2 = row.toLowerCase();
					if(dati2.contains(dati1)) {
						String d[] = row.split(", ");
						System.out.println(d[0]+" "+d[1]+" Phone: "+d[2]);
					}
					row = fetch.readLine();
				}
				fetch.close();
			}catch(IOException e) {
				System.out.println("Problem with file!");
			}	
		}
		static void SortData(int n) {
			String A[][] = new String[n][3];
			int i=0;
			System.out.println();
			try {
				BufferedReader fetch = new BufferedReader(new FileReader("names.txt"));
				String data = fetch.readLine();
				while(data != null) {
					String d[] = data.split(", ");
					A[i][0] = d[0];
					A[i][1] = d[1];
					A[i][2] = d[2];
					i++;
					data = fetch.readLine();
				}
				fetch.close();
				Arrays.sort(A, (a, b) -> a[1].compareToIgnoreCase(b[1]));
				for(i=0; i<n; i++) {
					System.out.println(A[i][0]+" "+A[i][1]+", phone: "+A[i][2]);
				}
				System.out.print("Data successfully sorted.\n");
			}catch(IOException e) {
				System.out.println("Problem with file!");
			}
		}
		static void DeleteContact() {
			ArrayList<String> ContactList = new ArrayList<>();
			try {
				BufferedReader fetch = new BufferedReader(new FileReader("names.txt"));
				System.out.print("Which Contact do you want to delete?:");
				String find = scan.nextLine();
				String row = fetch.readLine();
				String dati1 = find.toLowerCase();
				while(row != null) {
					String dati2 = row.toLowerCase();
					if(dati2.contains(dati1)) {
						String d[] = row.split(", ");
						System.out.println("Are you sure you want to delete this contact("+d[0]+" "+d[1]+")? [Y/N]");
						char choice = scan.next().charAt(0);
						if(choice!='y' && choice!='Y') ContactList.add(row);
					}else ContactList.add(row);
					row = fetch.readLine();
				}
				fetch.close();
				System.out.println("Contact successfully deleted.");
				try {
					BufferedWriter data = new BufferedWriter(new FileWriter("names.txt",false));
					for (String elem : ContactList) {
						data.write(elem+"\n");
					}
					data.close();
				}catch(IOException e) {
					System.out.println("Problem with file!");
				}
			}catch(IOException e) {
				System.out.println("Problem with file!");
			}	
			
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//NewPerson();
			//ReturnData();
			//int i = ReturnAmount();
			//System.out.print("Amount of contacts in the file is "+i+".");
			//System.out.println();
			//SortData(i);
			//DeleteContact();
			int nr;
			do {
				System.out.println("1. Add a Contact.");
				System.out.println("2. Show the Full Phonebook.");
				System.out.println("3. Sort the Phonebook by Surnames.");
				System.out.println("4. Find a person's phone number.");
				System.out.println("5. Delete a Contact.");
				System.out.println("6. Kill The Program.");
				System.out.print(">>");
				
				nr = scan.nextInt();
				scan.nextLine();
				switch(nr) {
				case 1: NewPerson(); break;
				case 2: ReturnData(); break;
				case 3: int i = ReturnAmount(); System.out.print("Amount of contacts in the file is "+i+"."); SortData(i); break;
				case 4: FindMember(); break;
				case 5: DeleteContact(); break;
				case 6: System.out.print("Goodbye. :)\n"); break;
				}
				pressEnterToContinue();
				clearScreen();
			}while(nr!=6);
			
			
			
			
		}

	}