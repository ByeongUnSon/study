
public class Exam_01 {

	public static void main(String[] args) {
		
		int totalCnt = 0;
		
		for (int i=1; i<=10000; i++) {
			int temp = i;
			while (temp > 0) {
				if (temp % 10 == 8) {
					totalCnt++;
				}
				temp /= 10;
			}			
		}
		
		System.out.println("1 ~ 10000 ������ ���� �߿��� 8�� �� ���ڴ� �� � ? " + totalCnt);
		
		
	}

}
