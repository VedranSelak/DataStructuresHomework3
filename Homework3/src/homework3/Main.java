package homework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		//initializing the file
		File file = new File("src/data.csv");
		//initializing the array where we are going to store the data
		IPAddress[] ipAddresses = new IPAddress[10000];
		//initializing the buffered reader to enable reading from the file
		BufferedReader br = new BufferedReader(new FileReader("src/data.csv"));
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
		//sorting the array using bubble sort
		BubbleSort.sort(ipAddresses);
		
		//storing the sorted file to the new file
		FileWriter writer = new FileWriter("src/new.csv");
		for (i=0; i<ipAddresses.length; i++) {
			writer.append(ipAddresses[i].toString());
			writer.append("\n");
		}
		writer.flush();
		writer.close();
		
		//printing the array
		for(i=0; i<ipAddresses.length; i++) {
			System.out.println((i+1) + ": " + ipAddresses[i].toString());
		}
	}

}
