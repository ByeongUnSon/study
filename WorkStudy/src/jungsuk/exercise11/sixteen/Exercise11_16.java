package jungsuk.exercise11.sixteen;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Exercise11_16 {

	/**
	 * 문자열 “123,456,789.5”를 소수점 첫 번째 자리에서 반올림하고, 그 값을 만
		단위마다 콤마(,)로 구분해서 출력하시오.
		
		data:123,456,789.5
		반올림:123456790
		만단위:1,2345,6790
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String data = "123,456,789.5";
		
		DecimalFormat df = new DecimalFormat("###,###.#");
		DecimalFormat df2 = new DecimalFormat("#,####");
		
		Number num = df.parse(data);
		double d = num.doubleValue();
		System.out.println("data:" + data);
		System.out.println("반올림:" + Math.round(d));
		System.out.println("만단위:" + df2.format(d));
	}

}
