package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static long convert(String address) {
		String[] list = address.split("\\.");
		long finalAddress = 16777216*Long.parseLong(list[0]) + 65536*Long.parseLong(list[1]) + 256*Long.parseLong(list[2]) + Long.parseLong(list[2]);
		return finalAddress;
	}
	
	public static void main(String[] args) throws IOException {
		//initializing the file (sorted file)
		File file = new File("src/new.csv");
		//initializing the array where we are going to store the data
		IPAddress[] ipAddresses = new IPAddress[10000];
		//initializing the buffered reader to enable reading from the file
		BufferedReader br = new BufferedReader(new FileReader("src/new.csv"));
		int i = 0;
		while (i < ipAddresses.length) {
			String row = br.readLine();
			//replacing occurrences of ", " so that we can split the line by using ","
			//this is done because for example there is a string "KOREA, REPUBLIC OF",... so we are first removing the commas inside the string
			row = row.replace(", ", " ");
		    String[] data = row.split(",");
		    //making a IPAddress object and adding it to the array
		    //the string that we are getting from the file looks like this ""FRANCE""
		    //therefore we have to get rid of the quotation marks using substring method
		    ipAddresses[i] = new IPAddress(Long.parseLong(data[0].substring(1,data[0].length()-1)),
		    							   Long.parseLong(data[1].substring(1,data[1].length()-1)),
		    							   data[2].substring(1,data[2].length()-1),
		    							   data[3].substring(1,data[3].length()-1),
		    							   data[4].substring(1,data[4].length()-1),
		    							   data[5].substring(1,data[5].length()-1));
		    i++;
		}
		br.close();
		
		//works for some
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter an IP address: ");
		String ipAddress = reader.nextLine();
		
		long num = convert(ipAddress); 
		int res = BinarySearch.search(ipAddresses, num);
		if(res == -1) {
			System.out.println("Not found");
		} else {
			System.out.println(ipAddresses[res].countryCode + ", " + ipAddresses[res].countryName + ", " + ipAddresses[res].regionName + ", " + ipAddresses[res].cityName);
		}
	}

}
