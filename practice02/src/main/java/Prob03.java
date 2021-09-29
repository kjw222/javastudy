

public class Prob03 {
	public static void main(String args[]) {
		
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };
		int count; 
		
		int length;
		for(count = 0; count<c.length;count++) {
			// 원래 배열 원소 출력
			printCharArray(c[count]);
		}
		System.out.println();
		for(count = 0; count<c.length;count++) {
			// 공백 문자 바꾸기
			c[count]=replaceSpace(c[count]);

			// 수정된 배열 원소 출력
			printCharArray(c[count]);
		}
		
		
	}
	

	private static char replaceSpace(char c) {
		if (c==32) {return 44;}
		else return c; 
		
	}

	static void printCharArray(char a) {
		
			System.out.print(a);
		
	}

}
