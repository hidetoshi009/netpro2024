import java.util.Scanner;

public class MyExceptionHoliday {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MyExceptionHoliday myE = new MyExceptionHoliday();
		while (true) {
			System.out.println("日にちを入力してください。");
			int day = scan.nextInt();
			try {
				myE.test(day);
			}catch (NoHolidayException e) {
				e.printStackTrace();
			}
		}
	}

	void test(int day) throws NoHolidayException {
		int holiday[] = { 3, 4, 5, 6, 11, 12, 18, 19, 25, 26 };
		for (int i = 0; i < holiday.length; i++) {
			if (day == holiday[i]) {
				throw new NoHolidayException();
			}
		}
	}
}
