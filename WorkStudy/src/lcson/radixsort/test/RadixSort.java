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
		// 스택에 해당값을 담기 위해 int 를 Integer 클래스로 타입 변환
		
		int num_digits = 0;	// 주어진 숫자가 몇 째 자리 이하인지 확인
		
		for (int i=0; i<arr.length; i++) {
			if (Integer.toString(arr[i]).length() > num_digits) {
				// 문자열로 변환, 최대 문자열 길이 구함
				num_digits = Integer.toString(arr[i]).length();
			}
		}
		// 문자열로 바꾸기 위해 새로 지정
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
				// 스택은 LIFO 이므로 뒤에 위치한 값부터 삽입
				int idx = (int) ((array[j].intValue() % (Math.pow(10, i+1))) / (Math.pow(10, i)));
				// 해당 자릿수의 숫자를 찾는다.
				// 가령 753 에서 10의 자릿수를 찾을 때, 즉 5를 찾기 위해
				
				s[idx].push(array[j]);	// 해당숫자에 해당하는 스택에 넣음
			}
			
			int k = 0;
			
			for (int j=0; j<s.length; j++) {	// 스택배열을 확인
				while (!s[j].empty()) {
					array[k++] = (Integer) s[j].pop(); // 차례대로 꺼낸다(LIFO)
				}
			}
			System.out.print("STEP " + (i+1) + " : ");
			// 각각의 단위 자리 별(1, 10, 100, ...) 정렬한 결과 값 출력
			displayArray_Integer(array); 
		}
		
		for (int j=0; j<array.length; j++) {
			arr[j] = array[j].intValue();	// 다시 int 배열로 변환
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
