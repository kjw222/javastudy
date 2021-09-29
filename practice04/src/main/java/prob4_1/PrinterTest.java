package prob4_1;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

		System.out.println("실행결과");
		
		printer.println( 10 );
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );
	}
}