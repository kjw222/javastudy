

import java.util.Scanner;

//substring, split 사용 가능 스레드 사용.

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");	//문자열 입력
		String text = scanner.nextLine();		//String text 에 문자열입력받음.
		int lenth = text.length();	//입력받은 text의 길이를 lenth에 저장
		String[] textArray = new String[lenth*2] ;		//한자씩 글자를 출력하기 위해 outtext라는 String 배열 선언
		
		
		for(int count =0;count<=lenth-1;count++) { 	//textArray 배열에 text 글자를 하나씩 넣기위한 반복문
			textArray[count]= text.substring(count, count+1); 		//textArray 배열에 count번째 text 글자를 쪼개서 넣음.
			//System.out.print(textArray[count]+", "+count+" ");
			//System.out.print(text.substring(count,count+1)+", "+count+" //");
		}
		System.out.println();
		for(int count =0;count<=lenth-1;count++) {		//textArray 배열에 있는 글자를 한줄씩 출력하기위한 for문
			for(int printcount =0;printcount<=count;printcount++) { //textArray 배열에 있는 글자를 count 만큼 한자씩 출력하기 위한 반복문
			System.out.print(textArray[printcount]+" ");		//textArray 배열을 count 숫자만큼 출력
			}
			System.out.println();
		
		}
		
		
		scanner.close();
	}

}
