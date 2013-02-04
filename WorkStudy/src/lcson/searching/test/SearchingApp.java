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
	
	// 선형탐색
	static void linearSearch(int iKey, int arr[]) {
		int i = 0; // 카운터 변수
		
		// 키 값을 찾거나 배열에 키 값이 존재하지 않을 때까지 탐색
		while (i < arr.length) {
			// 키 값이 존재한다면, 출력한다.
			if (arr[i] == iKey) {
				System.out.println(iKey + " is in the array with index value: " + i);
				break;
			}
			i++;
		}
	}
	
	// 이진탐색
	static void binarySearch(int iKey, int arr[]) {
		int mid; 					// 가운데 자료의 포인터
		int left = 0;				// 가장 왼쪽 자료의 포인터
		int right = arr.length - 1;	// 가장 오른쪽 자료의 포인터
		
		// right 가 left 보다 크거나 같을 경우
		while (right >= left) {
			
			// left 와 right 를 이용하여 mid 값을 계산
			mid = (right + left) / 2;
			
			// 찾고자 하는 키 값이 mid 가 가리키는 자료일 경우
			if (iKey == arr[mid]) {
				System.out.println(iKey + " is in the array with index value: " + mid);
				break;
			} 
			
			// 찾고자 하는 키 값이 mid 가 가리키는 자료보다 작을 경우
			if (iKey < arr[mid]) 
				right = mid - 1;
			// 찾고자 하는 키 값이 mid 가 가리키는 자료보다 클 경우
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
