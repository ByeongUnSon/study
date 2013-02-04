/**
 * 
 */
package jungsuk.exercise11.fourteen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar Ŭ������ SimpleDateFormatŬ������ �̿��ؼ� 2010���� �ſ� �� ��° �Ͽ����� ��¥�� ����Ͻÿ�.
 * 2010-01-10�� 2��° �Ͽ����Դϴ�. 2010-02-14�� 2��° �Ͽ����Դϴ�. 2010-03-14�� 2��° �Ͽ����Դϴ�.
 * 2010-04-11�� 2��° �Ͽ����Դϴ�. 2010-05-09�� 2��° �Ͽ����Դϴ�. 2010-06-13�� 2��° �Ͽ����Դϴ�.
 * 2010-07-11�� 2��° �Ͽ����Դϴ�. 2010-08-08�� 2��° �Ͽ����Դϴ�. 2010-09-12�� 2��° �Ͽ����Դϴ�.
 * 2010-10-10�� 2��° �Ͽ����Դϴ�. 2010-11-14�� 2��° �Ͽ����Դϴ�. 2010-12-12�� 2��° �Ͽ����Դϴ�.
 * 
 */
public class Exercise11_14 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2010, 0, 1);
		for (int i = 0; i < 12; i++) {
			int weekday = cal.get(Calendar.DAY_OF_WEEK);

			int secondSunday = weekday == 1 ? 8 : 16 - weekday;

			// �� ��° �Ͽ���(secondSunday)�� cal�� ��¥(DAY_OF_MONTH)�� �ٲ۴�.
			cal.set(Calendar.DAY_OF_MONTH, secondSunday);
			Date d = cal.getTime(); // Calendar�� Date�� ��ȯ�Ѵ�.
			System.out.println(new SimpleDateFormat("yyyy-MM-dd�� F��° E�����Դϴ�.").format(d));
			// ��¥�� ������ 1�Ϸ� �����Ѵ�.
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
		}

	}

}
