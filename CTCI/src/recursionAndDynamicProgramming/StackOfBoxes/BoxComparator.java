/**
 * 
 */
package recursionAndDynamicProgramming.StackOfBoxes;

import java.util.Comparator;

/**
 * Comparator for the Box class
 * 
 * @author Hammad: 19-Dec-2021
 */
public class BoxComparator implements Comparator<Box> {

	/**
	 * compare the height of two Box objects. Any dimension can be chosen to compare
	 * the two Box objects for sorting
	 */
	@Override
	public int compare(Box x, Box y) {

		return y.height - x.height;
	}

}
