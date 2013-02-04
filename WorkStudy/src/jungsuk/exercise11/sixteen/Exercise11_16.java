package jungsuk.exercise11.sixteen;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Exercise11_16 {

	/**
	 * ���ڿ� ��123,456,789.5���� �Ҽ��� ù ��° �ڸ����� �ݿø��ϰ�, �� ���� ��
		�������� �޸�(,)�� �����ؼ� ����Ͻÿ�.
		
		data:123,456,789.5
		�ݿø�:123456790
		������:1,2345,6790
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String data = "123,456,789.5";
		
		DecimalFormat df = new DecimalFormat("###,###.#");
		DecimalFormat df2 = new DecimalFormat("#,####");
		
		Number num = df.parse(data);
		double d = num.doubleValue();
		System.out.println("data:" + data);
		System.out.println("�ݿø�:" + Math.round(d));
		System.out.println("������:" + df2.format(d));
	}

}
