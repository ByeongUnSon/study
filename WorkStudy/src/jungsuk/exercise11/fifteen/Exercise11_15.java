package jungsuk.exercise11.fifteen;

import java.util.*;
import java.text.*;

class Exercise11_15 {
	static int paycheckCount(Calendar from, Calendar to) {
		/*
		 * (1) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1. from 또는 to가 null이면 0을 반환한다. 
		 * 2. from와 to가 같고 날짜가 21일이면 1을 반환한다. 
		 * 3. to와 from이 몇 개월 차이인지 계산해서 변수 monDiff에 담는다. 
		 * 4. monDiff가 음수이면 0을 반환한다. 
		 * 5. 만일 from의 일(DAY_OF_MONTH)이 21일이거나 이전이고 to의 일(DAY_OF_MONTH)이 21일이거나 이후이면 
		 * monDiff의 값을 1 증가시킨다. 
		 * 6. 만일 from의일(DAY_OF_MONTH)이 21일 이후고 to의 일(DAY_OF_MONTH)이 21일 이전이면 monDiff의 값을 1
		 * 감소시킨다.
		 */
		
		/**
		 * 	2010-01-01 ~ 2010-01-01:0
			2010-01-21 ~ 2010-01-21:1
			2010-01-01 ~ 2010-03-01:2
			2010-01-01 ~ 2010-03-23:3
			2010-01-23 ~ 2010-03-21:2
			2011-01-22 ~ 2010-03-21:0
		 */
		
		int monDiff = 0;
		
		if (from == null || to == null)
			return 0;
		
		if (from.equals(to) && from.get(Calendar.DAY_OF_MONTH) == 21)
			return 1;
		
		int fromYear = from.get(Calendar.YEAR);
		int fromMon = from.get(Calendar.MONTH);
		int toYear = to.get(Calendar.YEAR);
		int toMon = to.get(Calendar.MONTH);
		// 3. to와 from이 몇 개월 차이인지 계산해서 변수 monDiff에 담는다.
		//monDiff = (toYear * 12 + toMon) - (fromYear * 12 + fromMon);
		
		monDiff = (to.get(Calendar.YEAR) * 12 + (to.get(Calendar.MONTH))) 
			- (from.get(Calendar.YEAR) * 12 + (from.get(Calendar.MONTH)));
		
		if (monDiff < 0)
			monDiff = 0;
		if (from.get(Calendar.DAY_OF_MONTH) <= 21 && to.get(Calendar.DAY_OF_MONTH) >= 21)
			monDiff++;
		if (from.get(Calendar.DAY_OF_MONTH) > 21 && to.get(Calendar.DAY_OF_MONTH) < 21) 	
			monDiff--;
	
		
		System.out.println(monDiff);
		
		return monDiff;
	}

	static void printResult(Calendar from, Calendar to) {
		Date fromDate = from.getTime();
		Date toDate = to.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print(sdf.format(fromDate) + " ~ " + sdf.format(toDate)
				+ ":");
		System.out.println(paycheckCount(from, to));
	}

	public static void main(String[] args) {
		Calendar fromCal = Calendar.getInstance();
		Calendar toCal = Calendar.getInstance();
		fromCal.set(2010, 0, 1);
		toCal.set(2010, 0, 1);
		printResult(fromCal, toCal);
		fromCal.set(2010, 0, 21);
		toCal.set(2010, 0, 21);
		printResult(fromCal, toCal);
		fromCal.set(2010, 0, 1);
		toCal.set(2010, 2, 1);
		printResult(fromCal, toCal);
		fromCal.set(2010, 0, 1);
		toCal.set(2010, 2, 23);
		printResult(fromCal, toCal);
		fromCal.set(2010, 0, 23);
		toCal.set(2010, 2, 21);
		printResult(fromCal, toCal);
		fromCal.set(2011, 0, 22);
		toCal.set(2010, 2, 21);
		printResult(fromCal, toCal);
	}
}