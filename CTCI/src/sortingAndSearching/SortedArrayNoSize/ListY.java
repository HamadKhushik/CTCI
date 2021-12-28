/**
 * 
 */
package sortingAndSearching.SortedArrayNoSize;

/**
 * 10.4. custom array like data structure which does not have size()/length
 * method/field
 * 
 * @author Hammad: 28-Dec-2021
 */
public class ListY {

	int[] array;

	public ListY(int[] array) {
		this.array = array;
	}

	public int elementAt(int index) {

		if (array == null || index >= array.length || index < 0) {
			return -1;
		} else {
			return array[index];
		}
	}

}
