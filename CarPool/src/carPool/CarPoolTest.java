package carPool;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CarPoolTest {

	@Test
	public void testWhoDrivesMost() {
		Person Priya = new Person("Priya");
		Person Sita = new Person("Sita");
		Person Gita = new Person("Gita");
		Person X = new Person("X");
		Person Y = new Person("Y");
		ArrayList<String> members = new ArrayList();
		members.add("Priya");
		CarPool aCarPool = new CarPool(1, members);
		Person Driver;
		ArrayList<Person> beingDriven1 = new ArrayList<Person>();
		ArrayList<Person> absentees1 = new ArrayList<Person>();
		
		Driver = Priya;		
		WorkingDay aDay = aCarPool.createNewWorkingDay(Driver, beingDriven1, absentees1);
		aCarPool.history.add(aDay);
		assertEquals(Priya,aCarPool.whoDrivesMost());
		beingDriven1.add(Sita);
		beingDriven1.add(Gita);
		absentees1.add(X);
		aCarPool.history.clear();
		aDay = aCarPool.createNewWorkingDay(Driver, beingDriven1, absentees1);
		aCarPool.updateHistory(aDay);
		assertEquals(Priya,aCarPool.whoDrivesMost());
		ArrayList<Person> beingDriven2 = new ArrayList<Person>();
		ArrayList<Person> absentees2 = new ArrayList<Person>();
		beingDriven2.add(Sita);
		beingDriven2.add(Gita);
		absentees2.add(X);
		absentees2.add(Y);
		WorkingDay bDay = aCarPool.createNewWorkingDay(Driver, beingDriven1, absentees1);
		aCarPool.updateHistory(bDay);
		assertEquals(Priya,aCarPool.whoDrivesMost());
	}

	@Test
	public void testWhoIsDrivenMost() {
		Person Priya = new Person("Priya");
		Person Sita = new Person("Sita");
		Person Gita = new Person("Gita");
		Person X = new Person("X");
		Person Y = new Person("Y");
		ArrayList<String> members = new ArrayList();
		members.add("Priya");
		CarPool aCarPool = new CarPool(1, members);
		Person Driver;
		ArrayList<Person> beingDriven = new ArrayList<Person>();
		ArrayList<Person> absentees = new ArrayList<Person>();
		
		Driver = Priya;		
		WorkingDay aDay = aCarPool.createNewWorkingDay(Driver, beingDriven, absentees);
		aCarPool.history.add(aDay);
		assertNull("Nobody is driven",aCarPool.whoIsDrivenMost());
	}

	
}
