package weather;

public class WeatherDataLine {
	
	int day;
	int maxTemp;
	int minTemp;
	
	public WeatherDataLine(int day, int maxTemp, int minTemp) {
		super();
		this.day = day;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}
	
	
}
