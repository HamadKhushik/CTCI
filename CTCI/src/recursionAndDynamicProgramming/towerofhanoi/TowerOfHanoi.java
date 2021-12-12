/**
 * 
 */
package recursionAndDynamicProgramming.towerofhanoi;

/**
 * 8.6 Tower of Hanoi Problem
 * 
 * @author Hammad: 11-Dec-2021
 */
public class TowerOfHanoi {

	/*
	 * move the disk from top of source tower and place it on destinatio tower
	 */
	public void moveTopTo(Tower source, Tower destination) {
		int top = source.disks.pop();
		System.out.println(top);
		destination.addDisk(top);
	}

	public void moveDisks(int quantity, Tower source, Tower destination, Tower buffer) {

		if (quantity <= 0) {
			return;
		}

		moveDisks(quantity - 1, source, buffer, destination);
		moveTopTo(source, destination);
		System.out.println(source.id + ", " + destination.id);
		moveDisks(quantity - 1, buffer, destination, source);
	}
}
