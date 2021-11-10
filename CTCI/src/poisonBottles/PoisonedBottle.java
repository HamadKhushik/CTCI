package poisonBottles;

import java.util.ArrayList;

/*
 * runner class for to find poisoned bottle
 */
public class PoisonedBottle {

	public int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {

		int today = 0;

		while (bottles.size() > 1 && strips.size() > 0) {

			// run tests
			runTestSets(bottles, strips, today);

			// wait for results
			today += TestStrip.DAYS_FOR_RESULT;

			// check for poisoned Bottle
			for (TestStrip strip : strips) {
				if (strip.isPositiveOnDay(today)) {
					bottles = strip.getLastWeeksBottles(today);
					strips.remove(strip);
				}
			}
		}
		if (bottles.size() == 1) {
			return bottles.get(0);
		} else {
			return -1;
		}

	}

	public void runTestSets(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips, int day) {
		int index = 0;

		for (Bottle b : bottles) {
			TestStrip strip = strips.get(index);
			strip.addDropsFromBottle(day, b);
			index = (index + 1) % strips.size();
		}
	}

}
