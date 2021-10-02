package stackAndQueue;

/*
 * 3.6 Animal shelter
 * using abstract Animal class and two lists each for cats and dogs
 * depending classes: AnimalQueue, Dogs and Cats
 */

public abstract class AnimalShelter {

	private int order; // time stamp to track order of animals added
	private String name;

	public String getName() {
		return name;
	}

	public AnimalShelter(String n) {
		name = n;
	}

	public void setOrder(int ord) {
		order = ord;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(AnimalShelter a) {
		if (a == null) {
			return true;
		}
		return this.order < a.order;
	}

	@Override
	public String toString() {
		return name;
	}

}
