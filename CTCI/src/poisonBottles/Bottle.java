package poisonBottles;

public class Bottle {

	private boolean poisoned = false;
	private int id;

	public Bottle(int id) {
		this.id = id;
	}

	public void setAsPoisoned() {
		this.poisoned = true;
	}

	public int getId() {
		return this.id;
	}

	public boolean isPoisoned() {
		return this.poisoned;
	}
}
