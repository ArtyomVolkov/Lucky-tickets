package volkov;

import static org.junit.Assert.*;
import org.junit.Test;

public class LuckyTicketsTest {

	@Test
	public void testNumberIsLucky() {

		assertTrue(LuckyTickets.numberIsLucky(123006));
		assertTrue(LuckyTickets.numberIsLucky(106205));
		assertFalse(LuckyTickets.numberIsLucky(123456));
		assertFalse(LuckyTickets.numberIsLucky(103406));
	}

	@Test
	public void testVerifyNumber() {

		assertTrue(LuckyTickets.verifyNumber("174"));
		assertTrue(LuckyTickets.verifyNumber("879345"));
		assertFalse(LuckyTickets.verifyNumber("1000000"));
		assertFalse(LuckyTickets.verifyNumber("-123"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerifyNumberException() {

			LuckyTickets.verifyNumber("123.23");
			LuckyTickets.verifyNumber("asd");
			LuckyTickets.verifyNumber(null);
			
	}

	@Test
	public void testGetListOfLuckyNumbers() {

		assertTrue(LuckyTickets.getListOfLuckyNumbers(1, 1).isEmpty());
		assertFalse(LuckyTickets.getListOfLuckyNumbers(0, 12).isEmpty());
		assertTrue(LuckyTickets.getListOfLuckyNumbers(0, 1234).size() == 4);
		assertFalse(LuckyTickets.getListOfLuckyNumbers(2, 2).size() == 1);
	}
	
	@Test
	public void testVerifyArguments(){
		assertTrue(LuckyTickets.verifyArguments(new String [] {"23", "13445"}));
		assertFalse(LuckyTickets.verifyArguments(new String [] { "qwe"}));
		assertTrue(LuckyTickets.verifyArguments(new String [] {null, null}));
		assertFalse(LuckyTickets.verifyArguments(new String [] {}));
	}
}
