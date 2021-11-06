package mathAndLogicPuzzles;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PrimalityTest {

	Primality prime = new Primality();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void primalityTest() {
		assertEquals(true, prime.isPrime(7));
		assertEquals(true, prime.isPrime(5));
		assertEquals(true, prime.isPrime(11));
		assertEquals(true, prime.isPrime(17));
		assertEquals(false, prime.isPrime(0));
		assertEquals(false, prime.isPrime(1));
		assertEquals(false, prime.isPrime(4));
		assertEquals(false, prime.isPrime(22));
	}

	@Test
	public void sieveOfEratosthenesTest() {
		assertEquals(true, prime.sieveOfEratosthenes(7)[3]);
		assertEquals(false, prime.sieveOfEratosthenes(7)[4]);
		assertEquals(true, prime.sieveOfEratosthenes(7)[7]);
		assertEquals(false, prime.sieveOfEratosthenes(100)[99]);
		assertEquals(false, prime.sieveOfEratosthenes(0)[0]);
		assertEquals(false, prime.sieveOfEratosthenes(10)[10]);
		assertEquals(false, prime.sieveOfEratosthenes(7)[6]);
		assertEquals(true, prime.sieveOfEratosthenes(7)[5]);
	}
}
