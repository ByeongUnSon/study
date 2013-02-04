package jungsuk.exercise4.nine;

public class Exercise4_9 {

	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		/*for (int i=0; i<str.length(); i++) {
			int temp = Integer.parseInt(String.valueOf(str.charAt(i)));
			sum += temp;
		}
		System.out.println("sum=" + sum);
		
		char[] ch = null;
		for (int i=0; i<str.length(); i++) {
			ch = str.toCharArray();		
		}
		
		for (int i=0; i<ch.length; i++) {
			String s = String.valueOf(ch[i]);
			int temp = Integer.parseInt(s);
			sum += temp;
		}
		System.out.println("sum=" + sum);
		*/
		
		
		for (int i=0; i<str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println("sum=" + sum);
	}

}
