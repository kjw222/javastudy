

import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int scannum;
		int i, j;
		
		int sum = 0;

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		System.out.print("배열의 크기를 입력하시오 : ");
		scannum = scanner.nextInt();
		@SuppressWarnings("unused")
		int[] intArray = new int[ scannum ];
		
		
		/* 배열에 저장된 정수 값 더하기 */
		
		for(i =1;i<scannum+1;i++) {
			for(j =1;j<scannum+1;j++) {
				sum=sum+1;
				System.out.print(sum+" ");
			}
			System.out.println();
			sum=i;
		}
		
		/* 출력 */
		
		/* 자원정리 */
		scanner.close();
	}
}


