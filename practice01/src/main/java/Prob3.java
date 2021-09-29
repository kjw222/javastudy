import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		int input;
		int sum=0;
		for(;;) {
			System.out.print("숫자를 입력하세요 : ");
			input = scanner.nextInt();
			for(int start =0;start<=input;start++) {
				if(input%2==0) {
					if(start%2==0) {
					sum=sum+start;
					}	
				}
				else{
					if(start%2==1) {
						sum=sum+start;
						}
				}
			}
			System.out.println("결과값 : "+sum );
			
		}
		

	}
}
