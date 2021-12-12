/**
 * 
 */
package recursionAndDynamicProgramming.towerofhanoi;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 12-Dec-2021
 */
public class TowerOfHanoiTest {

	int n = 3;
	TowerOfHanoi testObject = new TowerOfHanoi();
	Tower t1 = new Tower("t1");
	Tower t2 = new Tower("t2");
	Tower t3 = new Tower("t3");
	Tower t4 = new Tower("t4");

	@Before
	public void setUp() throws Exception {
		t4.addDisk(3);
		t4.addDisk(2);
		t4.addDisk(1);

		t1.addDisk(4);
		t1.addDisk(3);
		t1.addDisk(2);
		t1.addDisk(1);
	}

	@Test
	public void MoveDisksTest() {

		// testObject.moveDisks(n, t1, t3, t2);
		// testObject.moveDisks(4, t1, t3, t2);
		testObject.moveDisks(2, t1, t3, t2);
	}

}
