package common;

public class DataLine {
	String subject;
	int firstValue;
	int secondValue;
	int spread;
	
	public DataLine(String subject, int firstValue, int secondValue) {
		this.subject = subject;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}
	
	public int getSpread() {
		return Math.abs(firstValue - secondValue);
	}
	
	public String getSubject() {
		return subject;
	}
}
