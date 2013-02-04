package jungsuk.exercise9.ten;

public class Exercise9_10 {
	
	/*
	 * 	�޼���� : format
		�� �� : �־��� ���ڿ��� ������ ũ���� ���ڿ��� ��ȯ�Ѵ�. ������ ������ �������� ä���.
		��ȯŸ�� : String
		�Ű����� : String str - ��ȯ�� ���ڿ�
		int length - ��ȯ�� ���ڿ��� ����
		int alignment - ��ȯ�� ���ڿ��� ��������
		(0:���� ����, 1: ��� ����, 2:������ ����)
	 */	
	/*
		(1) format�޼��带 �ۼ��Ͻÿ�.
			1. length�� ���� str�� ���̺��� ������ length��ŭ�� �߶� ��ȯ�Ѵ�.
			2. 1�� ��찡 �ƴϸ�, lengthũ���� char�迭�� �����ϰ� �������� ä���.
			3. ��������(alignment)�� ���� ���� ���ڿ�(str)�� ������ ��ġ�� �����Ѵ�.
			(System.arraycopy()���)
			4. 2���� ������ char�迭�� ���ڿ��� ���� ��ȯ�Ѵ�.
	*/
	
	static String format(String str, int length, int alignment) {
		int diff = length - str.length();
	
		if (diff < 0) {
			return str.substring(0, length);
		} else {
			char[] chArr = new char[length];
			char[] source = str.toCharArray();
			for (int i=0; i<chArr.length; i++) {
				chArr[i] = ' ';
			}
			switch (alignment) {
				case 0:
					System.arraycopy(source, 0, chArr, 0, source.length);
					break;
				case 1:
					System.arraycopy(source, 0, chArr, diff/2, source.length);
					break;
				case 2:
					System.arraycopy(source, 0, chArr, diff, source.length);
					break;
			}
			return new String(chArr);
		}
	}
	public static void main(String[] args) {
		String str = "������";
		System.out.println(format(str,7,0)); // ���� ����
		System.out.println(format(str,7,1)); // ��� ����
		System.out.println(format(str,7,2)); // ������ ����
	}

}
