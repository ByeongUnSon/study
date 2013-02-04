package jungsuk.exercise4.six;

public class Jusawi {

	public static void main(String[] args) {
				
		/* for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				if (i+j == 6)
					System.out.println(i + "+" + j + "=" + (i+j));
			}
		} */
		
		
		/*for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				if ((i+j) % 2 == 1)	// 두개의 주사위 합이 홀수일 경우만
					System.out.println(i + "+" + j + "=" + (i+j));
			}
		}*/
		
		
		for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				if ((i+j) % 2 == 1)	
					continue;
				// 두개의 주사위 합이 짝수일 경우만
				System.out.println(i + "+" + j + "=" + (i+j));				
			}
		}
	}

}
