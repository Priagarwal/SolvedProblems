package carPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CarPool {
	int numOfMembers;
	Date startDate;
	ArrayList<Person> members;
	ArrayList<WorkingDay> history;
	ArrayList<Date> holidays;
	HashMap<Person, Integer> NumDaysEachDrived = new HashMap<Person, Integer>();
	HashMap<Person, Integer> NumDaysEachWasDriven = new HashMap<Person, Integer>();
	
	CarPool(ArrayList<String> memberNames) {
		
	}
	CarPool(int numOfMembers, ArrayList<String> Members) {
		
	}
	int numWorkingDaysTillDate(){
		return 0;
	}
	Person whoDrivesMost() {
		return null;
	}
	
	Person whoIsDrivenMost() {
		return null;
	}
	ArrayList<Person> pplToDriveNext() {
		return null;
	}
	
	WorkingDay createNewWorkingDay(Person Driver, ArrayList<Person> beingDriven, ArrayList<Person> absentees) {
		return null;		
	}
	
	void updateHistory( WorkingDay today) {
		
	}
	
	void printHistory() {
		
	}
	
}
