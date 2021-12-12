/**
 * 
 */
package recursionAndDynamicProgramming.towerofhanoi;

import java.util.Stack;

/**
 * 8.6 -> class representing a tower in Tower of Hanoi problem
 * 
 * @author Hammad: 11-Dec-2021
 */
public class Tower {

	Stack<Integer> disks;
	String id;

	public Tower(String id) {
		disks = new Stack<Integer>();
		this.id = id;
	}

	public void addDisk(int d) {

		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk - larger disk on top of smaller disk not allowed " + d);
		} else {
			disks.push(d);
		}
	}
}
