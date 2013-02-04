package lcson.recursive.test;

// 삼각수를 구하기 위한 자바코드
public class Triangle {

	static int num;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("java triangle [num]");
		} else {
			num = Integer.parseInt(args[0]);
			int ans = triRec(num);

			System.out.println(num + " 번째 삼각수 = " + ans);
		}
	}

	public static int triRec(int n) {
		
		System.out.println("n = " + n + " 에 들어가기");
		
		if (n == 1) {
			System.out.println("1 반환");
			return 1;
		} else {
			int temp = n + triRec(n-1);
			System.out.println(temp + " 반환");
			return temp;
		}
	}

}
