package lcson.radixsort.test;

import java.util.*;

public class RadixSort {

	public static void main(String[] args) {
		int[] array = new int[10];
		
		array[0] = 753;
		array[1] = 427;
		array[2] = 450;
		array[3] = 422;
		array[4] = 220;
		array[5] = 125;
		array[6] = 332;
		array[7] = 339;
		array[8] = 199;
		array[9] = 660;
		
		System.out.print("*INPUT : ");
		displayArray_int(array);
		
		radixSort(array);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static int[] radixSort(int[] arr) {
		// ���ÿ� �ش簪�� ��� ���� int �� Integer Ŭ������ Ÿ�� ��ȯ
		
		int num_digits = 0;	// �־��� ���ڰ� �� ° �ڸ� �������� Ȯ��
		
		for (int i=0; i<arr.length; i++) {
			if (Integer.toString(arr[i]).length() > num_digits) {
				// ���ڿ��� ��ȯ, �ִ� ���ڿ� ���� ����
				num_digits = Integer.toString(arr[i]).length();
			}
		}
		// ���ڿ��� �ٲٱ� ���� ���� ����
		Integer[] array = new Integer[arr.length];
		
		for (int i=0; i<arr.length; i++) {
			array[i] = new Integer(arr[i]);
		}
		
		for (int i=0; i<num_digits; i++) {
			Stack[] s = new Stack[10];
			
			for (int j=0; j<s.length; j++) {
				s[j] = new Stack();
			}
			
			for (int j = array.length - 1; j>=0; j--) {
				// ������ LIFO �̹Ƿ� �ڿ� ��ġ�� ������ ����
				int idx = (int) ((array[j].intValue() % (Math.pow(10, i+1))) / (Math.pow(10, i)));
				// �ش� �ڸ����� ���ڸ� ã�´�.
				// ���� 753 ���� 10�� �ڸ����� ã�� ��, �� 5�� ã�� ����
				
				s[idx].push(array[j]);	// �ش���ڿ� �ش��ϴ� ���ÿ� ����
			}
			
			int k = 0;
			
			for (int j=0; j<s.length; j++) {	// ���ù迭�� Ȯ��
				while (!s[j].empty()) {
					array[k++] = (Integer) s[j].pop(); // ���ʴ�� ������(LIFO)
				}
			}
			System.out.print("STEP " + (i+1) + " : ");
			// ������ ���� �ڸ� ��(1, 10, 100, ...) ������ ��� �� ���
			displayArray_Integer(array); 
		}
		
		for (int j=0; j<array.length; j++) {
			arr[j] = array[j].intValue();	// �ٽ� int �迭�� ��ȯ
		}
		
		return arr;
	}
	
	static void displayArray_int(int[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	static void displayArray_Integer(Integer[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	

}
