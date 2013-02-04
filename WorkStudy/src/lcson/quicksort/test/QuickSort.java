package lcson.quicksort.test;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] array = new int[10];		
		
		array[0] = 1;
		array[1] = 11;
		array[2] = 88;
		array[3] = 55;
		array[4] = 99;
		array[5] = 77;
		array[6] = 66;
		array[7] = 44;
		array[8] = 22;
		array[9] = 33;
		
		displayArray(array);
		System.out.println();
		
		quickSort(array, 0, array.length - 1);
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");		// 정렬 후 배열 출력
		}
		System.out.println();		
	}
	
	public static void quickSort(int[] a, int leftmost, int rightmost) {
		if (rightmost - leftmost <= 0)	// 배열의 크기가 1이하이면 리턴
			return;
		else {							// 배열의 크기가 2이상일 때 퀵정렬 수행 
			int pivot = a[rightmost];
			
			int i = leftmost - 1;
			int j = rightmost;
			
			while (true) {
				
				while (a[++i] < pivot); // 왼쪽에서부터 피봇 값보다 큰 값 탐색
				
				while (j > leftmost && a[--j] > pivot); // 오른쪽에서부터 피봇 값보다 작은 값 탐색
				
				if (i >= j)		// 왼쪽과 오른쪽 위치가 크로스 되면 분할
					break;
				
				else			// 크로스 되지 않으면 항목끼리 치환
					swap(a, i, j);		
			}
			swap(a, i, rightmost);	// 왼쪽에서 탐색한 큰 값과 피봇과 치환
			
			quickSort(a, leftmost, i - 1);	// 재귀적으로 퀵 정렬 알고리즘 재호출
			
			quickSort(a, leftmost + 1, rightmost);	// 재귀적으로 퀵 정렬 알고리즘 재호출
		}
	}
	
	static void swap(int[] a, int i, int j) {		// 치환
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void displayArray(int[] arr) {			// 배열의 항목 출력
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	

}
