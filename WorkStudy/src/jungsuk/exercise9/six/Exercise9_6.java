/**
 * 
 */
package jungsuk.exercise9.six;

/**
 * @author Administrator
 * 
 */
public class Exercise9_6 {
	public static String fillZero(String src, int length) {
		/*
		 * (1) fillZero�޼��带 �ۼ��Ͻÿ�. 1. src�� ���̰ų� src.length()�� length�� ������ src��
		 * �״�� ��ȯ�Ѵ�. 2. length�� ���� 0���� ���ų� ������ �� ���ڿ�("")�� ��ȯ�Ѵ�. 3. src�� ���̰�
		 * length�� ������ ũ�� src�� length��ŭ �߶� ��ȯ�Ѵ�. 4. ���̰� legnth�� char�迭�� ��������.
		 * 5. 4���� ������ char�迭�� '0'���� ä���. 6. src���� ���ڹ迭�� �̾Ƴ��� 4���� ������ �迭�� �����Ѵ�.
		 * 7. 4���� ������ �迭�� String�� �����ؼ� ��ȯ�Ѵ�.
		 */
		if (src == null || src.length() == length) {
			return src;
		} else if (length <= 0) {
			return "";
		} else if (src.length() > length) {
			return src.substring(0, length);
		} else {
			char[] chArr = new char[length];
			for (int i=0; i<chArr.length; i++) {
				chArr[i] = '0';
			}
			
			System.arraycopy(src.toCharArray(), 0, chArr, length-src.length(), src.length());
			
			return new String(chArr);
		}
	}

	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src, 3));
	}
}
