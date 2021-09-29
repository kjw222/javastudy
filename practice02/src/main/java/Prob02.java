

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] intArray = new int[ 5 ];
		double sum = 0;

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		System.out.println(intArray.length+"개의 숫자를 입력하세요.");
		for(int count = 0; count<intArray.length; count++) {
			intArray[count]=scanner.nextInt();
		}
		
		/* 배열에 저장된 정수 값 더하기 */
		for(int count = 0; count<intArray.length; count++) {
			sum = sum+intArray[count];
		}
		
		/* 출력 */
		System.out.println("평균 : "+sum/intArray.length);

		
		/* 자원정리 */
		scanner.close();
	}
}
