package common;

public class DataLine {
	private String subject;
	private int firstValue;
	private int secondValue;
	
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
