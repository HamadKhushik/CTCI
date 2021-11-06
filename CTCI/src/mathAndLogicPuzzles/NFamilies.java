package mathAndLogicPuzzles;

import java.util.Random;

/*
 * 6.7 Get the ratio of number of girls and boys and girls in an Apocalypto world
 */
public class NFamilies {

	public double getNFamilies(int n) {

		int girls = 0;
		int boys = 0;

		int count = 0;
		while (count < n) {
			int[] genders = runOneFamily();
			girls += genders[0];
			boys += genders[1];
			count++;
		}
		return girls / (double) (girls + boys);
	}

	// runs one family and keeps having children until one girl is born
	public int[] runOneFamily() {

		Random random = new Random();
		int girls = 0;
		int boys = 0;

		while (girls == 0) {
			if (random.nextBoolean()) { // girls
				girls++;
			} else {
				boys++;
			}
		}
		int[] genders = { girls, boys };
		return genders;
	}

}
