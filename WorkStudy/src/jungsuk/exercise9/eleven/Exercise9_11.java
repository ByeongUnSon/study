package jungsuk.exercise9.eleven;

public class Exercise9_11 {

	/**
	 * Ŀ�ǵ�������� 2~9������ �� ���� ���ڸ� �޾Ƽ� �� ���ڻ����� �������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		���� ��� 3�� 5�� �Է��ϸ� 3�ܺ��� 5�ܱ��� ����Ѵ�.
	 */
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("���� �ܰ� �� ��, �� ���� ������ �Է����ּ���.\nUSAGE : GugudanTest 3 5");
		} else {
			int start = Integer.parseInt(args[0]);
			int end = Integer.parseInt(args[1]);
			
			for (int i=start; i<=end; i++) {
				for (int j=1; j<=9; j++) {
					System.out.println(i+"*"+j+"="+(i*j));
				}
				System.out.println();
			}
		}
	}

}
