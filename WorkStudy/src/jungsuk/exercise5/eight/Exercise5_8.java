package jungsuk.exercise5.eight;

public class Exercise5_8 {

	/*
	 * 		3***
			2**
			2**
			4****
	 */
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		for (int i = 0; i < answer.length; i++) {
			counter[answer[i]-1]++;
		}
		for (int i = 0; i < counter.length; i++) {
			System.out.print((i+1) + "�� ���� : " + counter[i] + " ");
			/*
			 * (2) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
			 */
			for (int j=0; j<counter[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
