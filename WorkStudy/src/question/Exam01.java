package question;
/**
 * 
 *  1 ~ 10000 ������ ���� �߿��� 8�� �� ����� �����°�?
  
 	- �������� : continue / break ���� ����.
 * 
 * @author LcSon
 *
 */
public class Exam01 {

	public static void main(String[] args) {	
		
		System.out.println("1 ~ 10000 ������ ���� �߿��� 8�� �� ��� ? : " + getCount(10000));
	}
	
	static int getCount(int size) {
		String[] temp = new String[size];	
		int totalCount = 0;		
		int cnt = 0;
		
		for (int i=0; i<size; i++) {
			temp[i] = ++cnt + "";		
		}
		int count = 0;
		
		for (int i=0; i<size; i++) {			
			char tempArr[] = temp[i].toCharArray();
			
			for (int j=0; j<tempArr.length; j++) {
				if ('8' == tempArr[j]) {
					count++;
					totalCount++;				
				}
			}
			System.out.println(temp[i] + "������ 8�� ���� : " + count);
			count = 0;
		}
		return totalCount;
	}
}
