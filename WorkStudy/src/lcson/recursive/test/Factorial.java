package lcson.recursive.test;

public class Factorial {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.err.println("java Factorial [num]");
		} else {
			int num = Integer.parseInt(args[0]);
			if (num <= 0) {
				System.err.println("1 이상의 숫자를 입력하세요");
			} else {
				int ans = factorial(num);			
				System.out.println(num + " 번째 순차곱셈 결과 = " + ans);
			}
		}
		
	}
	
	static int factorial(int n) {
		if (n <= 0) 
			return 1;
		else
			return n * factorial(n-1);
	}

}
