package mathAndLogicPuzzles;

import org.junit.Before;
import org.junit.Test;

public class EggDropTest {

	EggDrop egg = new EggDrop();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void breakingPointTest() {
		int breakingFloor = egg.findBreakingPoint(100);
		System.out.println(breakingFloor);
	}

}
