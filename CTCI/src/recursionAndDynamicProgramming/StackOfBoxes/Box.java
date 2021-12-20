/**
 * 
 */
package recursionAndDynamicProgramming.StackOfBoxes;

/**
 * 8.13 place a stack of boxes to get maximum height such that each box in the
 * stack is strictly larger than the box above it i-e biggest box on the bottom
 * and smallest box on the top.
 * 
 * This class represent the box
 * 
 * @author Hammad: 19-Dec-2021
 */
public class Box {

	int height;
	int width;
	int length;

	public Box(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}

	/**
	 * Check if 'this' object is smaller in all dimensions than 'b'
	 */
	public boolean canBeAbove(Box b) {

		return (this.height < b.height && this.width < b.width && this.length < b.length);

	}

}
