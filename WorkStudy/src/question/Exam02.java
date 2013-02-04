package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1~50의 숫자가 중복없이 배치된 5*5 빙고판을 출력하라.
 
	(출력예)
 
	43 30  8 15 18
	32 26 23  9 10
	39 46 36 12 24
	13 37 16 25 11
	49 21  5 33  1

 * @author LcSon
 *
 */
public class Exam02 {

	public static void main(String[] args) {
		Random ran = new Random();

		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		while (true) {
			int temp = ran.nextInt(50) + 1;
			if (!(list.contains(temp)))
				list.add(temp);
			if (list.size() == 25)
				break;
		}
		
		Object[] object = list.toArray();
		
		for (int i=object.length-1; i >=0; i--) {
			System.out.printf("%3s ", object[i]);
			count++;
			if (count % 5 == 0) {			
				System.out.println();
				count = 0;
			}
		}
		
	}

}
