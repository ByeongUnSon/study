package jungsuk.exercise5.five;

public class Exercise5_5 {

	public static void main(String[] args) {
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
		// �迭 ballArr�� ������ ��� 2���� ��� ��ġ�� �ٲ۴�. 20�� �ݺ�
		for (int x=0; x < 20; x++) {
			int i = (int) (Math.random() * ballArr.length);
			int j = (int) (Math.random() * ballArr.length);
			int tmp = 0;

			ballArr[tmp] = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = ballArr[tmp];			
			
		}
		
		// �迭 ballArr�� �տ��� 3���� ���� �迭 ball3�� �����Ѵ�.
		System.arraycopy(ballArr, 0, ball3, 0, ball3.length);
		
		for (int i=0; i<ball3.length; i++) {
			System.out.print(ball3[i]);
		}
	}

}