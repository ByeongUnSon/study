package lcson.recursive.test;

// �ﰢ���� ���ϱ� ���� �ڹ��ڵ�
public class Triangle {

	static int num;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("java triangle [num]");
		} else {
			num = Integer.parseInt(args[0]);
			int ans = triRec(num);

			System.out.println(num + " ��° �ﰢ�� = " + ans);
		}
	}

	public static int triRec(int n) {
		
		System.out.println("n = " + n + " �� ����");
		
		if (n == 1) {
			System.out.println("1 ��ȯ");
			return 1;
		} else {
			int temp = n + triRec(n-1);
			System.out.println(temp + " ��ȯ");
			return temp;
		}
	}

}
