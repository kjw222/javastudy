package prob3_4;

public class StringUtilTest extends StringUtil{

	public static void main(String[] args) {
        String[] strArr = {"SuperMan", "BatMan", "SpiderMan"}; 
        StringUtil stringutil = new StringUtil();
        stringutil.setMurge(strArr[0]);
        for(int count = 0; count<strArr.length;count++) {
        String resultStr = StringUtil.concatenate( strArr );
        	if(count == strArr.length-1) {System.out.println( "결과 문자열 : " + resultStr );}
        	else;
        }
         
	}

}
