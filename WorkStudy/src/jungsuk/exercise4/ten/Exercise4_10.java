package jungsuk.exercise4.ten;

public class Exercise4_10 {

	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while (num > 0) {
			//System.out.print(num % 10 + " ");
			sum += num % 10;
			num /= 10;		
		}		
		System.out.println("sum="+sum);
	}

}
