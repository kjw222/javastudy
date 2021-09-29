package prob3_3;

public class CurrencyConverter {

	private static double rate;
	public static void setRate(double d) {
		rate = d;
	}

	public static double toDollar(double d) {
		
		return d*rate;
	}

	public static double toKRW(double d) {
		return d;
	}

}
