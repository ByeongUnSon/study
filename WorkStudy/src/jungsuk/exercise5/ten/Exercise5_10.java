package jungsuk.exercise5.ten;

public class Exercise5_10 {
	public static void main(String[] args) {
		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*',
				'(', ')', '-', '_', '+', '=', '|', '[', ']', '{', '}', ';',
				':', ',', '.', '/' };
		
		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		
		String src = "abc123";
		String result = "";
		
		char[] temp = new char[abcCode.length];
		char chTemp= 'a';
		for (int i=0; i<temp.length; i++) {
			temp[i] = chTemp++;
		}
		char[] temp2 = new char[numCode.length];
		char chTemp2 = '0';
		for (int i=0; i<temp2.length; i++) {
			temp2[i] = chTemp2++;
		}
		
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			
			inLoop1: for (int j=0; j<abcCode.length; j++) {
				if (ch == temp[j]) {
					result += abcCode[j];
					break inLoop1;
				}
			}
			
			inLoop2: for (int k=0; k<numCode.length; k++) {
				if (ch == temp2[k]) {
					result += numCode[k];
					break inLoop2;
				}
			}
						
		}
		System.out.println("src:" + src);
		System.out.println("result:" + result);
	} // end of main
} // end of class