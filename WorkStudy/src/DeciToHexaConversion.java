
public class DeciToHexaConversion {

	public static void main(String[] args) {
		System.out.println(deciToHexa('자'));
	}
	
	final static char[] digits = {
		'0', '1', '2', '3', '4',
		'5', '6', '7', '8', '9',
		'a', 'b', 'c', 'd', 'e',
		'f'
	};
	
	static String deciToHexa(int i) {
		
		// int가 32bit이므로 16진수로는 8자리를 넘지 못한다.(2진수 4자리=16진수 1자리)
		char[] buf = new char[8];
		// buf를 뒤에서 부터 채우기 위해 사용하는 변수. 0부터가 아니라 7부터 채우기 위함
		int charPos = 8; 
		// 2진수로 1111
		int mask = 15;
		
		do {
			// i와 1111을 비트연산자 &로 연산한다. 이렇게 하면 16진수 한자리를 얻는다.
			buf[--charPos] = digits[i & mask];
			// i를 2의 4제곱(16)으로 나눈다.
			i >>>= 4; 
		} while (i != 0);
		
		// buf중에서 채워진 부분만 빼서 String으로 만들어 반환합니다.
		return new String(buf, charPos, (8 - charPos));
	}
	
}
