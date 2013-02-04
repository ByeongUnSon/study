package lcson.recursive.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fibonacci {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.err.println("java Fibonacci [num]");
		} else {
			String regex = ".*[0-9].*";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(args[0]);
			if (!m.matches())
				System.err.println("숫자를 입력하세요");
			else {
				int num = Integer.parseInt(args[0]);
				int ans = fibonacci(num);
				
				System.out.println(num + " 번째 피보나치 수 = " + ans);
			}
		}
		
	}
	
	static int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else 
			return (fibonacci(n-1) + fibonacci(n-2));
	}

}
