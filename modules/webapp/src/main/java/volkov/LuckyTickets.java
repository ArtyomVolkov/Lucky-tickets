package volkov;

import java.util.ArrayList;
import java.util.List;

public class LuckyTickets {

	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 1000000;

	public static void main(String[] args) {
		getLuckyTicketsInRage(args);
	}

	private LuckyTickets() {
	}

	public static boolean verifyArguments(String[] args) {
		if (args.length != 2) {
			return false;
		}
		else return true;
	}

	public static boolean verifyNumber(String value) {
		try {
			Integer.parseInt(value);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("The value must be integer number!");
		}
		if (Integer.parseInt(value) >= MIN_VALUE
				&& Integer.parseInt(value) < MAX_VALUE) {
			return true;
		} else
			return false;
	}

	public static boolean numberIsLucky(int number) {

		int x1 = number / 100000;
		int x2 = number % 100000 / 10000;
		int x3 = number % 10000 / 1000;
		int y1 = number % 1000 / 100;
		int y2 = number % 100 / 10;
		int y3 = number % 10;
		if (x1 + x2 + x3 == y1 + y2 + y3) {
			return true;
		} else
			return false;
	}

	public static List<Integer> getListOfLuckyNumbers(int begin, int end) {

		if (begin > end) {
			throw new IllegalArgumentException("Begin value must be less than end value!");
		}
		List<Integer> listOfLuckyTickets = new ArrayList<>();
		for (int i = begin; i <= end; i++) {

			if (numberIsLucky(i)) {
				listOfLuckyTickets.add(i);
			}
		}
		return listOfLuckyTickets;
	}

	private static void getLuckyTicketsInRage(String[] value) {
		if (!verifyArguments(value)){
			throw new IllegalArgumentException("Was not introduced 2 arguments!");
		}
		if(verifyNumber(value[0]) && verifyNumber(value[1])) {
			List<Integer> listOfLuckyTickets;
			listOfLuckyTickets = getListOfLuckyNumbers(
					Integer.parseInt(value[0]), Integer.parseInt(value[1]));
			
			if(listOfLuckyTickets.isEmpty()){
				System.out.println("In the specified range lucky numbers is absent.");
			}
			for (Integer ticket : listOfLuckyTickets) {
				System.out.format("%06d%n", ticket);
			}
		}
	}
}
