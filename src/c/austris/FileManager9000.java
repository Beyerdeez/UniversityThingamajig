package c.austris;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager9000 {
//generic file writer project i gotta repurpose.
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
				BufferedWriter config = new BufferedWriter(new FileWriter("data.txt",false));
				config.write("This was written by not a human.");
				config.newLine();
				int a=7, b=3, c;
				config.write(a+"+"+b+"=");
				c=a+b;
				config.write(Integer.toString(c));
				config.newLine();
				config.close();
				BufferedReader fetch = new BufferedReader(new FileReader("data.txt"));
				String data;
				data = fetch.readLine();
				int data1;
				double data2;
				data1=Integer.parseInt(fetch.readLine());
				data2=Double.parseDouble(fetch.readLine());
				while(data != null) {
					System.out.println(data);
					data = fetch.readLine();
					System.out.println(data1);
					data1 = data1 + Integer.parseInt(fetch.readLine());;
					System.out.println(data2);
					data2 = data2 + Double.parseDouble(fetch.readLine());
				}
				fetch.close();
			}catch(IOException e) {
				System.out.println("Problem with file!");
			}

	}

}
