package jungsuk.exercise4.fifteen;

public class Exercise4_15 {

	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		
		int result = 0; 	// ���� number �� �Ųٷ� ��ȯ�ؼ� ���� ����
		StringBuilder sb = new StringBuilder();

		while (tmp != 0) {
			int length = String.valueOf(tmp).length();
			
			for (int i=1; i<=length; i++) {
				sb.append((int)((tmp % Math.pow(10, i)) / Math.pow(10, i-1)));		
				if (i==length)
					tmp = 0;
			}	
		}		
		result = Integer.parseInt(sb.toString());

		if (number == result)
			System.out.println(number + "�� ȸ���� �Դϴ�.");
		else
			System.out.println(number + "�� ȸ������ �ƴմϴ�.");		
	}

}
