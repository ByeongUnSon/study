package jungsuk.exercise11.seventeen;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise11_17 {

	/**
	 * ȭ�����κ��� ��¥�� ��2007/05/11���� ���·� �Է¹޾Ƽ� ���� �������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		��, �Էµ� ��¥�� ������ �߸��� ��� �޼����� �����ְ� �ٽ� �Է¹޾ƾ� �Ѵ�.

		��¥�� yyyy/MM/dd�� ���·� �Է����ּ���.(�Է¿�:2007/05/11)
			>>2009-12-12
		��¥�� yyyy/MM/dd�� ���·� �Է����ּ���.(�Է¿�:2007/05/11)
			>>2009/12/12
		�Է��Ͻ� ��¥�� ������Դϴ�.
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		String regex = "\\d{4}/\\d{2}/\\d{2}";
		Pattern p = Pattern.compile(regex);
		while (true) {
			System.out.println("��¥�� yyyy/MM/dd�� ���·� �Է����ּ���.(�Է¿�:2007/05/11)");
			System.out.print(">>");
			String input = sc.next();
			Matcher m = p.matcher(input);
			if (m.matches()) {
				System.out.println(input);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
				Date d = sdf.parse(input);
				System.out.print("�Է��Ͻ� ��¥�� ");
				switch (d.getDay()) {
					case 0:
						System.out.print("�Ͽ���");
						break;
					case 1:
						System.out.print("������");
						break;
					case 2:
						System.out.print("ȭ����");
						break;
					case 3:
						System.out.print("������");
						break;
					case 4:
						System.out.print("�����");
						break;
					case 5:
						System.out.print("�ݿ���");
						break;
					case 6:
						System.out.print("�����");
						break;
					default:
				}
				System.out.println("�Դϴ�.");
				break;
			}
		}
		
	}

}
