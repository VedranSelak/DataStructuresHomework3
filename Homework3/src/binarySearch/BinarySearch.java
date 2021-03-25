package binarySearch;

public class BinarySearch {
	public static int search(IPAddress[] list, long address) {
		int low = 0;
		int high = list.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(list[mid].compareTo(address) == -1) {
				high = mid - 1;
			} else if(list[mid].compareTo(address) == 1) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
