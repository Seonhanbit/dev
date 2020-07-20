package setreci;

class Change {
	public long coin2 = 0;
	public long bill5 = 0;
	public long bill10 = 0;
}

public class sol1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long s =6L;
		long s = 9223372036854775807L;
		// long s=1L;
		solution(s);
	}

	static long resultTen, resultFive, resultTwo;
	static long resultSum;

	private static Change solution(long s) {
		// TODO Auto-generated method stub
		Change ch = new Change();
		resultTen = 0;
		resultFive = 0;
		resultTwo = 0;
		resultSum = Long.MAX_VALUE;
		recursive(s, 0, 0, 0);
		if (resultSum == Long.MAX_VALUE) {
			return null;
		} else {
			System.out.println(resultTen + " " + resultFive + " " + resultTwo);
			ch.coin2 = resultTwo;
			ch.bill5 = resultFive;
			ch.bill10 = resultTen;
			return ch;
		}
	}

	private static void recursive(long s, long ten, long five, long two) {
		// TODO Auto-generated method stub
		if (s == 0) {
			if (resultSum > ten + five + two) {
				resultSum = ten + five + two;
				resultTen = ten;
				resultFive = five;
				resultTwo = two;
			}
			return;
		}
		if (s >= 10) {
			recursive(s % 10, s / 10, five, two);
		}
		if (s >= 5) {
			recursive(s % 5, ten, s / 5, two);
		}
		if (s >= 2) {
			recursive(s % 2, ten, five, s / 2);
		}

	}

}
