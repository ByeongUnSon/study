package jungsuk.exercise4.six;

public class Jusawi {

	public static void main(String[] args) {
				
		/* for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				if (i+j == 6)
					System.out.println(i + "+" + j + "=" + (i+j));
			}
		} */
		
		
		/*for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				if ((i+j) % 2 == 1)	// �ΰ��� �ֻ��� ���� Ȧ���� ��츸
					System.out.println(i + "+" + j + "=" + (i+j));
			}
		}*/
		
		
		for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				if ((i+j) % 2 == 1)	
					continue;
				// �ΰ��� �ֻ��� ���� ¦���� ��츸
				System.out.println(i + "+" + j + "=" + (i+j));				
			}
		}
	}

}
