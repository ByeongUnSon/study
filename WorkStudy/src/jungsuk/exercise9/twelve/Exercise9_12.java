package jungsuk.exercise9.twelve;

public class Exercise9_12 {

	/**
	 * �޼���� : getRand
		�� �� : �־��� ����(from~to)�� ���� ������ �������� ��ȯ�Ѵ�.
		(���� ��谪 ��� ������ ����)
		from�� ���� to�� ������ Ŭ ��쵵 ó���Ǿ�� �Ѵ�.
		��ȯŸ�� : int
		�Ű����� : int from - ������ ���۰�
		int to - ������ ����
		[Hint] Math.random()�� ���밪�� ��ȯ�ϴ� Math.abs(int a), 
		�׸��� �� �߿� ���� ���� ��ȯ�ϴ� Math.min(int a, int b)�� ����϶�.
	 */
	
	static int getRand(int from, int to) {
		return (int) (Math.random()*(Math.abs(to-from)+1)) + Math.min(from,to);
	}
	
	public static void main(String[] args) {
		for(int i=0; i< 20; i++)
			System.out.print(getRand(1,-3)+",");
	}

}
