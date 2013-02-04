package lcson.searching.test;

import java.io.*;

public class SearchingApp {

	public static void main(String[] args) throws IOException {
		int[] dsInt = { 3, 7, 11, 12, 27, 49, 53, 68, 72, 91 };
		
		while (true) {
			System.out.println("-----------------------------");
			System.out.println("Searching Algorithm");
			System.out.println("--------------------");
			System.out.println("1. Linear Search");
			System.out.println("2. Binary Serach");
			System.out.println("3. Display List");
			System.out.println("4. End Program");
			
			System.out.print("Enter the number of command >> ");
			int command = getInt();
			int value;
			int i;
			
			switch (command) {
				case 1:
					System.out.print("Enter the number to search >> ");
					value = getInt();
					linearSearch(value, dsInt);
					System.out.println();
					break;
				case 2:
					System.out.print("Enter the number to search >> ");
					value = getInt();
					binarySearch(value, dsInt);
					System.out.println();
					break;
				case 3:
					for (i=0; i<dsInt.length; i++) 
						System.out.println(dsInt[i]);
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid entry");
			} 
		}
	}
	
	// ����Ž��
	static void linearSearch(int iKey, int arr[]) {
		int i = 0; // ī���� ����
		
		// Ű ���� ã�ų� �迭�� Ű ���� �������� ���� ������ Ž��
		while (i < arr.length) {
			// Ű ���� �����Ѵٸ�, ����Ѵ�.
			if (arr[i] == iKey) {
				System.out.println(iKey + " is in the array with index value: " + i);
				break;
			}
			i++;
		}
	}
	
	// ����Ž��
	static void binarySearch(int iKey, int arr[]) {
		int mid; 					// ��� �ڷ��� ������
		int left = 0;				// ���� ���� �ڷ��� ������
		int right = arr.length - 1;	// ���� ������ �ڷ��� ������
		
		// right �� left ���� ũ�ų� ���� ���
		while (right >= left) {
			
			// left �� right �� �̿��Ͽ� mid ���� ���
			mid = (right + left) / 2;
			
			// ã���� �ϴ� Ű ���� mid �� ����Ű�� �ڷ��� ���
			if (iKey == arr[mid]) {
				System.out.println(iKey + " is in the array with index value: " + mid);
				break;
			} 
			
			// ã���� �ϴ� Ű ���� mid �� ����Ű�� �ڷẸ�� ���� ���
			if (iKey < arr[mid]) 
				right = mid - 1;
			// ã���� �ϴ� Ű ���� mid �� ����Ű�� �ڷẸ�� Ŭ ���
			else
				left = mid + 1;
		}
	}
	
	
	public static int getInt() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return Integer.parseInt(s);
	}

}
