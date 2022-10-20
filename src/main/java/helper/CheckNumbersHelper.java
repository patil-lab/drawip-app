package helper;

public class CheckNumbersHelper {
	public static final String	positiveNumber="Negative number not allowed";
	public static final String	canvasMsg="Create canvas should have 2 params";
	public static final String	lineMsg="Draw Line  should have 4 params";
	public static final String	rectangleMsg="Draw Rectangle should have 4 params";
	public static final String	colorMsg="color fill should have 3 params";
	public static int positiveNumber(String input) throws IllegalArgumentException {
		int i = Integer.parseInt(input);
		if (i <= 0)
			throw new IllegalArgumentException();

		return i;
	}

	public static void isPositive(int... numbers) {
		for (int num : numbers) {
			if (num < 1) {
				throw new IllegalArgumentException("Number should be > 0");
			}
		}
	}

	public static void isNegative(int... numbers) {
		for (int num : numbers) {
			if (num < 0) {
				throw new IllegalArgumentException("Number should be > 0");
			}
		}
	}
}
