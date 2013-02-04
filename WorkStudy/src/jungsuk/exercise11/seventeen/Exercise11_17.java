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
	 * 화면으로부터 날짜를 “2007/05/11”의 형태로 입력받아서 무슨 요일인지 출력하는 프로그램을 작성하시오.
		단, 입력된 날짜의 형식이 잘못된 경우 메세지를 보여주고 다시 입력받아야 한다.

		날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예:2007/05/11)
			>>2009-12-12
		날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예:2007/05/11)
			>>2009/12/12
		입력하신 날짜는 토요일입니다.
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		String regex = "\\d{4}/\\d{2}/\\d{2}";
		Pattern p = Pattern.compile(regex);
		while (true) {
			System.out.println("날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예:2007/05/11)");
			System.out.print(">>");
			String input = sc.next();
			Matcher m = p.matcher(input);
			if (m.matches()) {
				System.out.println(input);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
				Date d = sdf.parse(input);
				System.out.print("입력하신 날짜는 ");
				switch (d.getDay()) {
					case 0:
						System.out.print("일요일");
						break;
					case 1:
						System.out.print("월요일");
						break;
					case 2:
						System.out.print("화요일");
						break;
					case 3:
						System.out.print("수요일");
						break;
					case 4:
						System.out.print("목요일");
						break;
					case 5:
						System.out.print("금요일");
						break;
					case 6:
						System.out.print("토요일");
						break;
					default:
				}
				System.out.println("입니다.");
				break;
			}
		}
		
	}

}
