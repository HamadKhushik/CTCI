package poisonBottles;

import java.util.ArrayList;

public class TestStrip {

	public static int DAYS_FOR_RESULT = 7;
	private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();
	private int id;

	public TestStrip(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	// increase the size of dropsByDay to number of days
	private void sizeDropsForDay(int day) {

		while (dropsByDay.size() <= day) {
			dropsByDay.add(new ArrayList<Bottle>());
		}
	}

	// add drops from bottle on specific day
	public void addDropsFromBottle(int day, Bottle bottle) {

		sizeDropsForDay(day);
		ArrayList<Bottle> drops = dropsByDay.get(day);
		drops.add(bottle);
	}

	// checks if any of the bottles are poisoned
	public boolean isPoisoned(ArrayList<Bottle> bottles) {

		for (Bottle b : bottles) {
			if (b.isPoisoned()) {
				return true;
			}
		}
		return false;
	}

	// gets bottles used in test DAYS_FOR_RESULT days ago
	public ArrayList<Bottle> getLastWeeksBottles(int day) {

		if (day < DAYS_FOR_RESULT) {
			return null;
		}
		return dropsByDay.get(day - DAYS_FOR_RESULT);
	}

	// checks for poisoned bottles since before DAYS_FOR_RESULT
	public boolean isPositiveOnDay(int day) {

		int testDay = day - DAYS_FOR_RESULT;
		if (testDay < 0 || testDay >= dropsByDay.size()) {
			return false;
		}

		for (int i = 0; i < testDay; i++) {
			ArrayList<Bottle> bottles = dropsByDay.get(i);
			if (isPoisoned(bottles)) {
				return true;
			}
		}
		return false;
	}

}
