package jungsuk.exercise4.five;

public class Exercise4_5 {

	public static void main(String[] args) {
		
		for (int i=0; i<=10; i++) {
			for (int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		int k = 0;
		while (k<=10) {
			int s = 0;
			while (s<=k) {
				System.out.print("*");
				s++;
			}
			System.out.println();
			k++;
		}

	}

}
