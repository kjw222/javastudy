package prob3_4;

public class StringUtil {
	static String murge;
	
	public static String getMurge() {
		return murge;
	}
	public static void setMurge(String strArr) {
		murge = strArr;
	}
	public static String concatenate(String[] strArr) {
		
		return murge+strArr;
	}
}
