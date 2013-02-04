package jungsuk.exercise11.nineteen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
 * 메서드명 : getDayDiff
	기 능 : yyyymmdd형식의 두 문자열을 넘겨받으면 두 날짜의 차이를 일(day)단위로 반환한다.
	단, 첫 번째 날짜 빼기 두 번째 날짜의 결과를 반환한다.
	만일 주어진 문자열이 유효하지 않으면 0을 반환한다.
	반환타입 : int
	매개변수 : String yyyymmdd1 - 시작날짜
	String yyyymmdd2 - 끝 날짜
 */
class Exercise11_19 {
	
	static SimpleDateFormat format = new SimpleDateFormat("yyyymmdd");
	
	static int getDayDiff(String ymd1, String ymd2) {
		
		try {
			int result = format.parse(ymd1).getDay() - format.parse(ymd2).getDay();
			return result;
		} catch (ParseException e) {
			return 0;
		}		
	}
	
	public static void main(String[] args) {
		System.out.println(getDayDiff("20010103", "20010101"));
		System.out.println(getDayDiff("20010103", "20010103"));
		System.out.println(getDayDiff("20010103", "200103"));
	}
}