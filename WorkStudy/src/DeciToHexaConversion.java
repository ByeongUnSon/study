
public class DeciToHexaConversion {

	public static void main(String[] args) {
		System.out.println(deciToHexa('��'));
	}
	
	final static char[] digits = {
		'0', '1', '2', '3', '4',
		'5', '6', '7', '8', '9',
		'a', 'b', 'c', 'd', 'e',
		'f'
	};
	
	static String deciToHexa(int i) {
		
		// int�� 32bit�̹Ƿ� 16�����δ� 8�ڸ��� ���� ���Ѵ�.(2���� 4�ڸ�=16���� 1�ڸ�)
		char[] buf = new char[8];
		// buf�� �ڿ��� ���� ä��� ���� ����ϴ� ����. 0���Ͱ� �ƴ϶� 7���� ä��� ����
		int charPos = 8; 
		// 2������ 1111
		int mask = 15;
		
		do {
			// i�� 1111�� ��Ʈ������ &�� �����Ѵ�. �̷��� �ϸ� 16���� ���ڸ��� ��´�.
			buf[--charPos] = digits[i & mask];
			// i�� 2�� 4����(16)���� ������.
			i >>>= 4; 
		} while (i != 0);
		
		// buf�߿��� ä���� �κи� ���� String���� ����� ��ȯ�մϴ�.
		return new String(buf, charPos, (8 - charPos));
	}
	
}
