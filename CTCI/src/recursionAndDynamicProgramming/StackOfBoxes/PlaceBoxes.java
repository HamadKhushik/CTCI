/**
 * 
 */
package recursionAndDynamicProgramming.StackOfBoxes;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 8.13 place a stack of boxes to get maximum height such that each box in the
 * stack is strictly larger than the box above it i-e biggest box on the bottom
 * and smallest box on the top.
 * 
 * @author Hammad: 19-Dec-2021
 */
public class PlaceBoxes {

	public static int createStack(ArrayList<Box> boxes) {

		if (boxes == null || boxes.size() == 0) {
			return 0;
		}

		int maxHeight = 0;
		Collections.sort(boxes, new BoxComparator()); // sort the arraayList in descending order

		for (int i = 0; i < boxes.size(); i++) {

			int height = createStack(boxes, i);
			maxHeight = Math.max(height, maxHeight);
		}
		return maxHeight;
	}

	private static int createStack(ArrayList<Box> boxes, int bottomIndex) {

		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;

		for (int k = bottomIndex + 1; k < boxes.size(); k++) {
			if (boxes.get(k).canBeAbove(bottom)) {
				int height = createStack(boxes, k);
				maxHeight = Math.max(height, maxHeight);
			}
		}

		maxHeight += bottom.height;
		return maxHeight;
	}

	// solution using memoization
	public static int createStack2(ArrayList<Box> boxes) {

		if (boxes == null || boxes.size() == 0) {
			return 0;
		}

		Collections.sort(boxes, new BoxComparator()); // sort the arraayList in
		// descending order
		int maxHeight = 0;
		int[] map = new int[boxes.size()]; // map to cache the results

		for (int i = 0; i < boxes.size(); i++) {
			int height = createStack2(boxes, i, map);
			maxHeight = Math.max(height, maxHeight);
		}

		return maxHeight;
	}

	private static int createStack2(ArrayList<Box> boxes, int bottomIndex, int[] map) {

		if (map[bottomIndex] > 0) {
			return map[bottomIndex];
		}

		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;

		for (int k = bottomIndex + 1; k < boxes.size(); k++) {

			if (boxes.get(k).canBeAbove(bottom)) {
				int height = createStack2(boxes, k, map);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		maxHeight += bottom.height;
		map[bottomIndex] = maxHeight;
		return maxHeight;
	}

	/*
	 * Second approach to calculating the height. Calculate the height by both
	 * including and not including the current box and then return the greater
	 * height. Makes use of Memoization
	 */
	public static int createStack3(ArrayList<Box> boxes) {

		if (boxes == null || boxes.size() == 0) {
			return 0;
		}

		Collections.sort(boxes, new BoxComparator()); // sort the arraayList in descending order
		int[] map = new int[boxes.size()];
		return createStack3(boxes, null, 0, map);
	}

	private static int createStack3(ArrayList<Box> boxes, Box bottom, int offset, int[] map) {

		if (offset >= boxes.size()) { // base case
			return 0;
		}

		Box newBottom = boxes.get(offset);
		int heightWithNewBottom = 0;

		// calculate height with newBottom(Box) on top of bottom(Box) - if valid
		if (bottom == null || newBottom.canBeAbove(bottom)) {
			if (map[offset] == 0) {
				map[offset] = createStack3(boxes, newBottom, offset + 1, map);
				map[offset] += newBottom.height;
			}
			heightWithNewBottom = map[offset];
		}

		// calculate height without newBottom
		int heightWithoutNewBottom = createStack3(boxes, bottom, offset + 1, map);

		// return the maximum height
		return Math.max(heightWithNewBottom, heightWithoutNewBottom);
	}
}
