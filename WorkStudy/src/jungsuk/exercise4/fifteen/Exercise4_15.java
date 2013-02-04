package jungsuk.exercise4.fifteen;

public class Exercise4_15 {

	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		
		int result = 0; 	// 변수 number 를 거꾸로 변환해서 담을 변수
		StringBuilder sb = new StringBuilder();

		while (tmp != 0) {
			int length = String.valueOf(tmp).length();
			
			for (int i=1; i<=length; i++) {
				sb.append((int)((tmp % Math.pow(10, i)) / Math.pow(10, i-1)));		
				if (i==length)
					tmp = 0;
			}	
		}		
		result = Integer.parseInt(sb.toString());

		if (number == result)
			System.out.println(number + "는 회문수 입니다.");
		else
			System.out.println(number + "는 회문수가 아닙니다.");		
	}

}
