package jungsuk.exercise4.four;

public class SwapMorseSum {

	public static void main(String[] args) {
	
		int sum = 0;
		int temp = 0;
		int i = 1;
		for (int t=1; true ; t++, i=-i) {
			temp = t * i;
			sum += temp;
			if (sum >=100) {
				temp = t;
				break;
			}
		}
		System.out.println(temp+" 까지 더해야 총합이 " + sum);
	

		
	}

}
