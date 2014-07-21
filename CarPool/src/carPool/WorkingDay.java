package carPool;

import java.util.ArrayList;
import java.util.Date;


public class WorkingDay {

	Date today;
	Person Driver;
	ArrayList<Person> pplBeingDriven;
	ArrayList<Person> absentees;
	int numOfPplGoingToday;
	
	WorkingDay(Person Driver, ArrayList<Person> beingDriven, ArrayList<Person> absentees)  {
		this.today = new Date();
		this.Driver = Driver;
		this.pplBeingDriven = beingDriven;
		this.absentees = absentees;
		numOfPplGoingToday = 1 + beingDriven.size();
	}
	
	ArrayList<Person> getAbsentees() {
		return absentees;
	}
	
	ArrayList<Person> pplBeingDriven() {
		return pplBeingDriven;
	}
	
	void setAbsentees(ArrayList<Person> absentees) {
		this.absentees = absentees;
	}
	
	void setPplBeingDriven(ArrayList<Person> pplBeingDriven) {
		this.pplBeingDriven = pplBeingDriven;
	}
	
}
