package mathAndLogicPuzzles;

public class EggDrop {

	int breakingPoint = 99;
	int count = 0;

	boolean dropEgg(int floor) {

		count++;
		return floor >= breakingPoint;
	}

	int findBreakingPoint(int floors) {

		int interval = 14;
		int previousFloor = 0;
		int egg1 = interval;

		// egg1
		while (egg1 < floors && !dropEgg(egg1)) {

			interval--;
			previousFloor = egg1;
			egg1 += interval;
		}

		// egg2
		int egg2 = previousFloor;
		while (egg2 < egg1 && egg2 <= floors && !dropEgg(egg2)) {
			egg2++;
		}
		System.out.println("Count: " + count);
		// return -1 if egg did not break
		return egg2 > floors ? -1 : egg2;
	}
}
