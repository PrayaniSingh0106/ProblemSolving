package leetCode;

import java.util.Calendar;

public class DateOfMonth {

	/*
	 * Complete the 'ada' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts INTEGER
	 * year as parameter.
	 */

	public static int ada(int year) {
		Calendar c = Calendar.getInstance();
		int dayOfWeeknum = 3;
		int month = 9;
		int nthOccurence = 2;
		int count = 0;

		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, 1);

		while (true) {
			if (c.get(Calendar.DAY_OF_WEEK) == dayOfWeeknum) {
				count++;
			}
			if (count == nthOccurence)
				break;

			c.add(Calendar.DATE, 1);
			if (c.get(Calendar.MONTH) != month)
				break;

		}
		System.out.print(c.get(Calendar.DAY_OF_MONTH));
		return c.get(Calendar.DAY_OF_MONTH);
	}

}
