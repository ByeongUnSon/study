package jungsuk.exercise11.eighteen;

/**
 * Comment Add Test
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Exercise11_18 {
	
	public static void main(String[] args) {
		String[] phoneNumArr = { "012-3456-7890", 
								 "099-2456-7980",
								 "088-2346-9870", 
								 "013-3456-7890" 
							   };
		ArrayList<Object> list = new ArrayList<Object>();
		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.print(">>");
			String input = s.nextLine().trim();

			if (input.equals("")) {
				continue;
			} else if (input.equalsIgnoreCase("Q")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			String regex = ".*"+input+".*";
			Pattern p = Pattern.compile(regex);
			for (int i=0; i<phoneNumArr.length; i++) {
				String phoneNum = phoneNumArr[i];
				
				String tmp = phoneNum.replace("-", "");
				
				Matcher m = p.matcher(tmp);
				if (m.find()) {
					list.add(phoneNum);
				}
			}			
			
			if (list.size() > 0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("일치하는 번호가 없습니다.");
			}
		}
	} // main
}