package jungsuk.exercise11.seventeen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercise11_17_2 {

	public static void main(String[] args) {
				
		String pattern = "yyyy/mm/dd";
		String pattern2 = "�Է��Ͻ� ��¥�� E�����Դϴ�.";
		
		DateFormat df = new SimpleDateFormat(pattern);
		DateFormat df2 = new SimpleDateFormat(pattern2);
		
		Scanner s = new Scanner(System.in);
		Date inDate = null;
		
		do {
			System.out.println("��¥�� " + pattern + " �� ���·� �Է����ּ���.");
			try {
				System.out.print(">>");
				inDate = df.parse(s.next());
				break;
			} catch (Exception e) {}
			
		} while (true);
		
		System.out.println(df2.format(inDate));
	}

}
