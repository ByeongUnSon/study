package lcson.recursive.test;

public class Factorial {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.err.println("java Factorial [num]");
		} else {
			int num = Integer.parseInt(args[0]);
			if (num <= 0) {
				System.err.println("1 �̻��� ���ڸ� �Է��ϼ���");
			} else {
				int ans = factorial(num);			
				System.out.println(num + " ��° �������� ��� = " + ans);
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
