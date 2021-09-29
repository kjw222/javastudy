

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		int num;
		while( true ) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			
			
			
			for(;;) {
				System.out.println("수를 결정하였습니다. 맞추어 보세요. 1~100");
				for(int count=1;count<100;count++) {
					System.out.print(count+"번째로 선택한 숫자>>");
					num = scanner.nextInt();
						if(num > correctNumber) {
							System.out.println("더 낮게");
						}
						else if(num < correctNumber) {
							System.out.println("더 높게");
						}else {
							System.out.println("맞았습니다.");
							break;
						}
					}
				//새 게임 여부 확인하기
				System.out.print( "다시 하겠습니까(y/n)>>" );
				String answer = scanner.next();
				if( "y".equals( answer ) == false ) {
					break;
				} else break;
			
			
			
			}
		}
	}

}