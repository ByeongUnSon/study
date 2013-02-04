package jungsuk.exercise11.nineteen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
 * �޼���� : getDayDiff
	�� �� : yyyymmdd������ �� ���ڿ��� �Ѱܹ����� �� ��¥�� ���̸� ��(day)������ ��ȯ�Ѵ�.
	��, ù ��° ��¥ ���� �� ��° ��¥�� ����� ��ȯ�Ѵ�.
	���� �־��� ���ڿ��� ��ȿ���� ������ 0�� ��ȯ�Ѵ�.
	��ȯŸ�� : int
	�Ű����� : String yyyymmdd1 - ���۳�¥
	String yyyymmdd2 - �� ��¥
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