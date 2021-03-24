package homework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void sort(IPAddress[] list) {
        for (int i = 0; i < list.length-1; i++) { 
            for (int j = 0; j < list.length-i-1; j++) {
                if(list[j].compareTo(list[j+1]) == 1) {
                	 IPAddress temp = list[j];
                	 list[j] = list[j+1];
                	 list[j+1] = temp;
                }
            }
        }
	}

	public static void main(String[] args) throws IOException {
		File file = new File("src/data.csv");
		IPAddress[] ipAddresses = new IPAddress[10000];
		BufferedReader br = new BufferedReader(new FileReader("src/data.csv"));
		int i = 0;
		while (i < 10000) {
			//need to work out "," problem
			String row = br.readLine();
		    String[] data = row.split(",");
		    ipAddresses[i] = new IPAddress(Long.parseLong(data[0].substring(1,data[0].length()-1)),Long.parseLong(data[1].substring(1,data[1].length()-1)),data[2].substring(1,data[2].length()-1).replace(",", " "),data[3].substring(1,data[3].length()-1).replace(",", " "),data[4].substring(1,data[4].length()-1).replace(",", " "),data[5].substring(1,data[5].length()-1).replace(",", " "));
		    i++;
		}
		br.close();
		sort(ipAddresses);
		for(i=0; i<10000; i++) {
			System.out.println(ipAddresses[i].toString());
		}
	}

}
