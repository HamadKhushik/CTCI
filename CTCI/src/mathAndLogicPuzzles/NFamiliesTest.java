package mathAndLogicPuzzles;

import org.junit.Before;
import org.junit.Test;

public class NFamiliesTest {

	NFamilies families = new NFamilies();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		for (int i = 10; i < 1000; i += 10) {
			System.out.println("count: " + i + " " + String.format("%.4f", families.getNFamilies(i)));
		}

	}

}
