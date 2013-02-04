package jungsuk.exercise4.three;

public class TotalSum {

	public static void main(String[] args) {
		int temp = 1;
		int sum = 0;
		do {
			for (int i=1; i<=temp; i++) {
				if (i==10)
					System.out.print(i);
				else
					System.out.print(i + "+");
				sum += i;

			}

			temp++;
		} while (temp <=10);
		
		System.out.println();
		System.out.println("°á°ú : " + sum);
	}
	

}
