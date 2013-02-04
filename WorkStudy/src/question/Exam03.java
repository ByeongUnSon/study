package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		List<Integer> comList = new ArrayList<Integer>();
		while (true) {
			int temp = ran.nextInt(9)+1;
			
			if (!(comList.contains(temp)))
				comList.add(temp);
			if (comList.size() == 3)
				break;
		}
		
		System.out.print("숫자를 입력하세요 : ");

		
		
		
	}

}
