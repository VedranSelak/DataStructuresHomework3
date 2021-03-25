package binarySearch;

public class IPAddress implements Comparable<Long>{
	long ipFrom;
	long ipTo;
	String countryCode;
	String countryName;
	String regionName;
	String cityName;
	
	public IPAddress(long ipFrom, long ipTo, String countryCode, String countryName, String regionName, String cityName) {
		this.ipFrom = ipFrom;
		this.ipTo = ipTo;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionName = regionName;
		this.cityName = cityName;
	}
	
	@Override
	public int compareTo(Long address) {
		if(this.ipFrom <= address && this.ipTo >= address) {
			return 0;
		} else if (this.ipFrom > address ) {
			return -1;
		} else {
			return 1;
		}
	}

	public String toString() {
		return "\"" + this.ipFrom + "\"" + "," + "\"" + this.ipTo + "\"" + "," + "\"" + this.countryCode + "\"" + "," + "\"" + this.countryName + "\"" + "," + "\"" + this.regionName + "\"" + "," + "\"" + this.cityName + "\"" ;
	}
}
