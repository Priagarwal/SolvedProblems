package carPool;

public class Person {

	String name;
	int numDaysDrivenByOthers;
	int numDaysDrivedOthers;
	int numDaysWasAbsent;
	
	Person( String name) {
		this.name = name;
		this.numDaysDrivenByOthers = 0;
		this.numDaysDrivedOthers = 0;
		this.numDaysWasAbsent = 0;
	}
	
	void incrementDaysDrivenByOthers() {
		this.numDaysDrivenByOthers++;
	}
	
	void incrementDaysDroveOthers() {
		this.numDaysDrivedOthers++;
	}
	void incrementDaysWasAbsent() {
		this.numDaysWasAbsent++;
	}
	
	
}
