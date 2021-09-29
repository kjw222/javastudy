

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] moneyArray = new int[10]; // money Array에는 각각 0번쨰 자리에 50000원의 갯수, 1번째에는 10000원의 갯수를 삽입할 예정.
		int price;
		System.out.print("금액을 입력하시오 : ");
		price = scanner.nextInt();
		
		for(int count = 0; count<MONEYS.length ;count++) {
			if(price/1!=0) {
				moneyArray[count] = (price/MONEYS[count]);
				price = price%MONEYS[count];
			}
			else;
			System.out.println(MONEYS[count]+"원 : "+moneyArray[count]+"개");
		}
		
		scanner.close();
 	}
}