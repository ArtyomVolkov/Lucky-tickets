package volkov;

import java.util.Scanner;

public class LuckyTickets {

	public static void main(String[] args) {
		getLuckyNumbers();
	}

	private static boolean isInteger(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean containsWhiteSpace(String value) {
		if (value != null) {
			for (int i = 0; i < value.length(); i++) {
				if (Character.isWhitespace(value.charAt(i))) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean verifyValue(String value) {
		boolean verifyValue = false;
		if (!containsWhiteSpace(value) && isInteger(value)
				&& Integer.parseInt(value) <= 999999
				&& Integer.parseInt(value) >= 0)
			verifyValue = true;
		return verifyValue;
	}

	private static void showLuckyNumbers(int begin, int end) {
		int count = 0;
		System.out.println("Lucky numbers: ");
		for (int i = begin; i <= end; i++) {

			int x1 = i / 100000;
			int x2 = i % 100000 / 10000;
			int x3 = i % 10000 / 1000;
			int y1 = i % 1000 / 100;
			int y2 = i % 100 / 10;
			int y3 = i % 10;

			if (x1 + x2 + x3 == y1 + y2 + y3) {
				System.out.format("%06d%n", i);
				count++;
			}
		}
		System.out.println("Found lucky tickets: " + count);
		System.out.println("In the search of range from: "+ String.format("%06d", begin) + " to: "
				+ String.format("%06d", end));
	}

	private static void getLuckyNumbers() {
		int firstGroupNumbers;
		int secondGroupNumbers;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first group of six-digit numbers:");
		String valuefirst = scan.nextLine();
		while (!verifyValue(valuefirst)) {
			System.out.println(" Input ERROR, try again! \n Enter the first group of six-digit numbers:");
			valuefirst = scan.nextLine();
		}
		firstGroupNumbers = Integer.parseInt(valuefirst);

		System.out.println("Enter the second group of six-digit numbers:");
		String valuesecond = scan.nextLine();
		while (!verifyValue(valuesecond)) {
			System.out.println(" Input ERROR, try again! \n Enter the second group of six-digit numbers:");
			valuesecond = scan.nextLine();
		}
		secondGroupNumbers = Integer.parseInt(valuesecond);
		scan.close();

		int begin = 0;
		int end = 0;

		if (firstGroupNumbers > secondGroupNumbers) {
			begin = secondGroupNumbers;
			end = firstGroupNumbers;
		} else {
			begin = firstGroupNumbers;
			end = secondGroupNumbers;
		}

		showLuckyNumbers(begin, end);
	}
}
